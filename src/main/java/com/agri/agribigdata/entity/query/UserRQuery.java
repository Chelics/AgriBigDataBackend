package com.agri.agribigdata.entity.query;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRQuery {
    private String username;
    private String tel;
    private String email;
    private String password;
}
