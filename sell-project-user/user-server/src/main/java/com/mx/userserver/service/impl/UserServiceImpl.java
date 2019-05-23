package com.mx.userserver.service.impl;

import com.mx.userserver.domain.UserInfo;
import com.mx.userserver.repository.UserRepository;
import com.mx.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mx
 * @date 2019/5/22 1:54 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo findUserInfoByUserId(Integer id) {
        return userRepository.findUserInfoByUserId(id);
    }

    @Override
    public UserInfo findUserInfoByOpenId(String openId) {
        return userRepository.findByOpenId(openId);
    }
}
