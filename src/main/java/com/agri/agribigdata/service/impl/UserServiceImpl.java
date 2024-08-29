package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.query.PersonalQuery;
import com.agri.agribigdata.entity.query.UserRQuery;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.mapper.UserMapper;
import com.agri.agribigdata.service.UserService;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.utils.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(UserBO userBO) throws CustomException {
        if(isDuplicatedUsername(userBO)){
            throw new CustomException(400,"重复的用户名");
        }else if(isDuplicatedTel(userBO)){
            throw new CustomException(400,"该电话号码已注册过本系统, 不可重复注册");
        }else if(isDuplicatedEmail(userBO)){
            throw new CustomException(400,"该邮箱已注册过本系统, 不可重复注册");
        }else{
            userMapper.register(userBO);
        }
    }

    @Override
    public boolean isDuplicatedUsername(UserBO userBO){
        return userMapper.checkDoubleUsername(userBO);
    }

    @Override
    public boolean isDuplicatedTel(UserBO userBO){
        return userMapper.checkDoubleTel(userBO);
    }

    @Override
    public boolean isDuplicatedEmail(UserBO userBO){
        return userMapper.checkDoubleEmail(userBO);
    }

    @Override
    public UserBO transferUserRQ2B(UserRQuery userRQuery){
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1); // 设置workerId和datacenterId
        UserBO userBO = new UserBO();
        userBO.setId(idGenerator.generateStringId());
        userBO.setUsername(userRQuery.getUsername());
        userBO.setPassword(userRQuery.getPassword());
        userBO.setTel(userRQuery.getTel());
        userBO.setEmail(userBO.getEmail());
        return userBO;
    }

    @Override
    public UserBO login(UserPQuery userPQuery) {
        return userMapper.getByUsernameAndPassword(userPQuery);
    }




    @Override
    public void setPersonal(PersonalQuery personalQuery) throws CustomException {
        String userId = userMapper.getIdByUsername(personalQuery.getUsername());
        if(userId == null){
            throw new CustomException(404,"用户不存在");
        }
        userMapper.setPrcv(userId, personalQuery.getPrvc());
        List<String> pzList = personalQuery.getPzList();
        if(pzList == null){
            throw new CustomException(400,"品种列表为空");
        }else{
            userMapper.clearPersonalPz(userId);
            for (String pz : personalQuery.getPzList()) {
                userMapper.setPz(userId,pz);
            }
        }
    }

}
