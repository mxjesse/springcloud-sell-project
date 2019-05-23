package com.mx.userserver.repository;

import com.mx.userserver.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author mx
 * @date 2019/5/22 11:06 AM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserInfoByUserId() {

        System.err.println(userRepository.findUserInfoByUserId(1));
    }

    @Test
    public void saveUserInfo() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("123456");
        userInfo.setUserType(1);
        userInfo.setCreateTime(new Date());
        UserInfo info = userRepository.save(userInfo);
    }

    @Test
    public void findByOpenId() {

        UserInfo userInfo = userRepository.findByOpenId("abc");
        System.err.println(userInfo);
    }
}