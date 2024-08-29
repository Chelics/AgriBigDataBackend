package com.agri.agribigdata.service;


import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.PersonalQuery;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.entity.query.UserRQuery;
import com.agri.agribigdata.exception.CustomException;


public interface UserService {

    void register(UserBO userBO) throws CustomException;
    boolean isDuplicatedUsername(UserBO userBO);
    boolean isDuplicatedTel(UserBO userBO);
    boolean isDuplicatedEmail(UserBO userBO);
    UserBO transferUserRQ2B(UserRQuery userRQuery);
    UserBO login(UserPQuery userPQuery);


    void setPersonal(PersonalQuery personalQuery) throws CustomException;
}
