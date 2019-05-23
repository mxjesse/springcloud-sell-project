package com.mx.userserver.service;

import com.mx.userserver.domain.UserInfo;

/**
 * @author mx
 * @date 2019/5/22 1:54 PM
 */
public interface UserService {

    UserInfo findUserInfoByUserId(Integer id);

    UserInfo findUserInfoByOpenId(String openId);
}
