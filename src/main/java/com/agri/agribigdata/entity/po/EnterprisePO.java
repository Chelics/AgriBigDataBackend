package com.agri.agribigdata.entity.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterprisePO {
    private String name;
    private String prvc;
    private String pz;
    private String supplyType;
    private String manager;
    private String email;
    private String phone;
    private String fixedPhone;
    private String qq;
    private String addr;
}
