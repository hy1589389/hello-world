package com.hotel.service.impl;

import com.hotel.dto.UserLoginRequest;
import com.hotel.dto.UserRegisterRequest;
import com.hotel.entity.User;
import com.hotel.repository.UserRepository;
import com.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 用户业务层实现
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserRegisterRequest request) {
        // 检查用户名是否已存在
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("用户名已存在");
        }

        // 检查邮箱是否已存在
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("邮箱已被注册");
        }

        // 检查手机号是否已存在
        if (userRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("手机号已被注册");
        }

        // 创建新用户
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // 实际应该加密
                .realName(request.getRealName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .userType(0) // 普通用户
                .status(1) // 启用状态
                .createTime(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }

    @Override
    public String login(UserLoginRequest request) {
        // 查询用户
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());

        if (!userOptional.isPresent()) {
            throw new RuntimeException("用户不存在");
        }

        User user = userOptional.get();

        // 验证密码（实际应该使用加密比较）
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        // 检查用户是否被禁用
        if (user.getStatus() == 0) {
            throw new RuntimeException("用户已被禁用");
        }

        // 返回token（实际应该生成JWT token）
        return "token_" + user.getId() + "_" + System.currentTimeMillis();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
