package com.agri.agribigdata.entity.bo;
import cn.hutool.core.bean.BeanUtil;
import com.agri.agribigdata.entity.po.UserPO;
import com.agri.agribigdata.entity.query.UserRQuery;
import com.agri.agribigdata.entity.query.UserVQuery;
import com.agri.agribigdata.utils.PasswordUtils;
import com.agri.agribigdata.utils.SnowflakeIdGeneratorUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBO {
    private String id;
    private String username;
    private String tel;
    private String email;
    private String password;
    private String prvc;
    private String verifyCode;
    private Date verifyTime;
    private List<String> interestedPzList;

    public static UserBO transferUserRQ2B(UserRQuery userRQuery) throws Exception{
        SnowflakeIdGeneratorUtils idGenerator = new SnowflakeIdGeneratorUtils(1, 1); // 设置workerId和datacenterId
        UserBO userBO = new UserBO();
        userBO.setId(idGenerator.generateStringId());
        userBO.setUsername(userRQuery.getUsername());
        userBO.setPassword(PasswordUtils.encrypt(userRQuery.getPassword()));
        //userBO.setPassword(userRQuery.getPassword());
        userBO.setTel(userRQuery.getTel());
        userBO.setEmail(userRQuery.getEmail());
        return userBO;
    }

    public static UserBO transferUserVQ2B(UserVQuery userVQuery){
        UserBO userBO = new UserBO();
        userBO.setTel(userVQuery.getTel());
        userBO.setEmail(userVQuery.getEmail());
        userBO.setVerifyCode(userBO.getVerifyCode());
        return userBO;
    }

    public static UserBO transferUserP2B(UserPO userPO, List<String> pzList){
        UserBO userBO = new UserBO();
        BeanUtil.copyProperties(userPO,userBO);
        userBO.setInterestedPzList(pzList);
        return userBO;
    }
}