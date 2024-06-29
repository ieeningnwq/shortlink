package com.ieening.shortlink.admin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ieening.shortlink.admin.common.convention.result.Result;
import com.ieening.shortlink.admin.common.convention.result.Results;
import com.ieening.shortlink.admin.dto.resp.UserRespDTO;
import com.ieening.shortlink.admin.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户管理层
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByName(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }
}
