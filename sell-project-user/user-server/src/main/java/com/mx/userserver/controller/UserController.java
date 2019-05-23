package com.mx.userserver.controller;

import com.mx.userserver.constants.CookieConstant;
import com.mx.userserver.constants.RedisConstant;
import com.mx.userserver.domain.UserInfo;
import com.mx.userserver.enums.ResultEnum;
import com.mx.userserver.enums.RoleEnum;
import com.mx.userserver.service.UserService;
import com.mx.userserver.util.CookieUtil;
import com.mx.userserver.util.ResultVOUtil;
import com.mx.userserver.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author mx
 * @date 2019/5/22 10:47 AM
 */
@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 卖家登录验证
     *
     * @param openId
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openId") String openId, HttpServletRequest request, HttpServletResponse response) {

        // 判断是否已经登录
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (cookie != null && !StringUtils.isEmpty(
                stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue()))
            )) {
            return ResultVOUtil.success();
        }

        // 1.openId和数据库是否匹配
        UserInfo userInfo = userService.findUserInfoByOpenId(openId);
        if (userInfo == null) {
            return ResultVOUtil.fail(ResultEnum.LOGIN_FAIL);
        }
        // 2.判断角色
        if (RoleEnum.SELLER.getUserType() != userInfo.getUserType()) {
            return ResultVOUtil.fail(ResultEnum.ROLE_ERROR);
        }
        // 3.设置UUID进redis (key = UUID, value = openId)
        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token), openId,
                CookieConstant.EXPIRE, TimeUnit.SECONDS);

        // 4.返回cookie设置openId
        CookieUtil.setCookie(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }

    /**
     * 买家登录验证
     *
     * @param openId
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openId") String openId, HttpServletRequest request, HttpServletResponse response) {

        // 判断是否已经登录

        // 1.openId和数据库是否匹配
        UserInfo userInfo = userService.findUserInfoByOpenId(openId);
        if (userInfo == null) {
            return ResultVOUtil.fail(ResultEnum.LOGIN_FAIL);
        }
        // 2.判断角色
        if (RoleEnum.BUYER.getUserType() != userInfo.getUserType()) {
            return ResultVOUtil.fail(ResultEnum.ROLE_ERROR);
        }
        // 3.cookie里设置openId
        CookieUtil.setCookie(response, CookieConstant.OPENID, openId, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }
}
