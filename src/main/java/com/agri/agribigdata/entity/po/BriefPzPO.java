package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BriefPzPO {
    private String pz;
    private Double average;
    private String lowPrvc;
    private String highPrvc;
}
