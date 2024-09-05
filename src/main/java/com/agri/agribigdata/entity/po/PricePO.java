package com.agri.agribigdata.entity.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePO {
    private String market;
    private String prvc;
    private String pz;
    private double highest;
    private double lowest;
    private double average;
    private String releaseTime;

}
