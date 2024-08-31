package com.agri.agribigdata.entity.query;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVQuery {
    private String tel = null;
    private String email = null;
    private String vcode = null;
}
