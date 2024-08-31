package com.agri.agribigdata.entity.bo;
import com.agri.agribigdata.entity.query.UserRQuery;
import com.agri.agribigdata.entity.query.UserVQuery;
import com.agri.agribigdata.utils.SnowflakeIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBO {
    private String id;
    private String username;
    private String tel;
    private String email;
    private String password;
    private String prvcId;
    private String verifyCode;
    private Date verifyTime;

    public static UserBO transferUserRQ2B(UserRQuery userRQuery){
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1); // 设置workerId和datacenterId
        UserBO userBO = new UserBO();
        userBO.setId(idGenerator.generateStringId());
        userBO.setUsername(userRQuery.getUsername());
        userBO.setPassword(userRQuery.getPassword());
        userBO.setTel(userRQuery.getTel());
        userBO.setEmail(userBO.getEmail());
        return userBO;
    }

    public static UserBO transferUserVQ2B(UserVQuery userVQuery){
        UserBO userBO = new UserBO();
        userBO.setTel(userVQuery.getTel());
        userBO.setEmail(userVQuery.getEmail());
        userBO.setVerifyCode(userBO.getVerifyCode());
        return userBO;
    }
}