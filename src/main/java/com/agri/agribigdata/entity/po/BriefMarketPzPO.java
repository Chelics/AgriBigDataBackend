package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BriefMarketPzPO {
    String market;
    String pz;
    Double average;
    Double highest;
    Double lowest;
    Double variation;
    Double predictTd;
    Double predictTm;
}
