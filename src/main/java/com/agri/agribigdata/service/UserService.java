package com.agri.agribigdata.service;


import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.PersonalQuery;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.entity.query.UserVQuery;
import com.agri.agribigdata.exception.CustomException;


public interface UserService {

    void register(UserBO userBO) throws CustomException;
    boolean isDuplicatedUsername(UserBO userBO);
    boolean isDuplicatedTel(UserBO userBO);
    boolean isDuplicatedEmail(UserBO userBO);
    UserBO loginWithPassword(UserPQuery userPQuery);

    void loginWithVCode(UserVQuery userVQuery) throws CustomException;

    void sendEmail(String to);
    void sendSms(String tel);

    void setPersonal(PersonalQuery personalQuery) throws CustomException;


}
