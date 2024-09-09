package com.agri.agribigdata.entity.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {
    private String id;
    private String username;
    private String tel;
    private String email;
    private String password;
    private String prvc;
    private String verifyCode;
    private Date verifyTime;
}
