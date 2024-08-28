package com.agri.agribigdata.service;


import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;


public interface UserService {

    //用户登录
    UserBO login(UserPQuery userPQuery);
}
