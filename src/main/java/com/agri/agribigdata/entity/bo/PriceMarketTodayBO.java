package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceMarketTodayBO {
    private double highest;
    private String highestPz;
    private double lowest;
    private String lowestPz;
}
