package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.mapper.UserMapper;
import com.agri.agribigdata.service.UserService;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO login(UserPQuery userPQuery) {
        return userMapper.getByUsernameAndPassword(userPQuery);
    }
}
