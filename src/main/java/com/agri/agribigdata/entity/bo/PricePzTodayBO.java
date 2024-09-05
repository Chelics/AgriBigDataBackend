package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePzTodayBO {
    private double highest;
    private String highestMarket;
    private double lowest;
    private String lowestMarket;
}
