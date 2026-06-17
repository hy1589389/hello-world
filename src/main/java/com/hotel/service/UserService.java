package com.hotel.service;

import com.hotel.dto.UserLoginRequest;
import com.hotel.dto.UserRegisterRequest;
import com.hotel.entity.User;

import java.util.Optional;

/**
 * 用户业务层接口
 */
public interface UserService {

    /**
     * 用户注册
     */
    User register(UserRegisterRequest request);

    /**
     * 用户登录
     */
    String login(UserLoginRequest request);

    /**
     * 根据ID查询用户
     */
    Optional<User> getUserById(Long id);

    /**
     * 根据用户名查询用户
     */
    Optional<User> getUserByUsername(String username);

    /**
     * 更新用户信息
     */
    User updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(Long id);

}
