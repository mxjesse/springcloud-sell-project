package com.mx.userserver.repository;

import com.mx.userserver.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mx
 * @date 2019/5/22 11:01 AM
 */
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findUserInfoByUserId(Integer userId);

    UserInfo findByOpenId(String openId);
}
