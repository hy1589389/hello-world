package com.hotel.controller;

import com.hotel.common.ApiResponse;
import com.hotel.dto.UserLoginRequest;
import com.hotel.dto.UserRegisterRequest;
import com.hotel.entity.User;
import com.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public ApiResponse<User> register(@Valid @RequestBody UserRegisterRequest request) {
        try {
            User user = userService.register(request);
            return ApiResponse.success(user);
        } catch (Exception e) {
            log.error("用户注册失败", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ApiResponse<String> login(@Valid @RequestBody UserLoginRequest request) {
        try {
            String token = userService.login(request);
            return ApiResponse.success(token);
        } catch (Exception e) {
            log.error("用户登录失败", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id) {
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                return ApiResponse.success(user.get());
            } else {
                return ApiResponse.fail(404, "用户不存在");
            }
        } catch (Exception e) {
            log.error("获取用户信息失败", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            user.setId(id);
            User updatedUser = userService.updateUser(user);
            return ApiResponse.success(updatedUser);
        } catch (Exception e) {
            log.error("更新用户信息失败", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("删除用户失败", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

}
