package com.agri.agribigdata.entity.bo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}