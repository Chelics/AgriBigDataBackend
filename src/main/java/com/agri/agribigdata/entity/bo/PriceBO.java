package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceBO {
    private String pzName;
    private String marketName;
    private String prvcName;
    private Double highest;
    private Double lowest;
    private Double average;
    private Double salesVolume;
    private Double hb;
    private Double rise;
    private Double increment;
}
