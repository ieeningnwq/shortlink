package com.ieening.shortlink.admin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ieening.shortlink.admin.common.convention.result.Result;
import com.ieening.shortlink.admin.common.convention.result.Results;
import com.ieening.shortlink.admin.dto.resp.UserActualRespDTO;
import com.ieening.shortlink.admin.dto.resp.UserRespDTO;
import com.ieening.shortlink.admin.service.UserService;

import cn.hutool.core.bean.BeanUtil;
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
     * 根据用户名查询脱敏后用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByName(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名查询用户真实信息
     */
    @GetMapping("/api/shortlink/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByName(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }
}
