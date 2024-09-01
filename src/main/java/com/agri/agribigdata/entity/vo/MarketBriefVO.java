package com.agri.agribigdata.entity.vo;


import com.agri.agribigdata.entity.po.MarketPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketBriefVO {
    private String name;
    private String prvc;
    private String unitType;
    private String addr;
    private String entryDate;
    private String openingDate;
    private String manager;
    private String managerPhone;
    private String tel;
    private String characteristic;
    private String content;
}
