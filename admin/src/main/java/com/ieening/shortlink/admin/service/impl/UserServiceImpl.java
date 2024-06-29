package com.ieening.shortlink.admin.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ieening.shortlink.admin.common.convention.exception.ClientException;
import com.ieening.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.ieening.shortlink.admin.dao.entity.UserDo;
import com.ieening.shortlink.admin.dao.mapper.UserMapper;
import com.ieening.shortlink.admin.dto.resp.UserRespDTO;
import com.ieening.shortlink.admin.service.UserService;

/**
 * 用户服务接口实现层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDo> queryWrapper = Wrappers.lambdaQuery(UserDo.class).eq(UserDo::getUsername, username);
        UserDo userDo = baseMapper.selectOne(queryWrapper);
        if (userDo == null) {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDo, result);
        return result;
    }

}
