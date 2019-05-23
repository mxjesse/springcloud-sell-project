package com.mx.sellprojectzuul.filter;

import com.mx.sellprojectzuul.constants.CookieConstant;
import com.mx.sellprojectzuul.constants.RedisConstant;
import com.mx.sellprojectzuul.util.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @author mx
 * @date 2019/5/22 4:27 PM
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // /order/create 只能买家访问
        // /order/finish 只能卖家访问
        // /order/list 都能访问

        if ("/order/order/create".equals(request.getRequestURI())) {

            Cookie cookie = CookieUtil.getCookie(request, CookieConstant.OPENID);
            if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }

        if ("/order/order/finish".equals(request.getRequestURI())) {

            Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
            if (cookie == null || StringUtils.isEmpty(cookie.getValue())
                || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }
        return null;

    }
}
