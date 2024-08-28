package com.agri.agribigdata.entity.bo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBO {
    private String userName;
    private String tel;
    private String email;
    private String password;
    private Integer prvcId;
    private String verifyCode;
    private Date verifyTime;
}