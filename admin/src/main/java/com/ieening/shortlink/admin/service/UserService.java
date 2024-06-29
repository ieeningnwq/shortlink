package com.ieening.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ieening.shortlink.admin.dao.entity.UserDo;
import com.ieening.shortlink.admin.dto.resp.UserRespDTO;

/**
 * UserService 用户服务接口层
 */
public interface UserService extends IService<UserDo> {
    /**
     * 根据用户名查询用户信息
     * 
     * @param username 用户名
     * @return 用户返回实体
     */
    UserRespDTO getUserByUsername(String username);
}
