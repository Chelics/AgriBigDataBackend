package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceMarketWeekBO {
    private double highest;
    private String highestReleaseTime;
    private String highestPz;
    private double lowest;
    private String lowestReleaseTime;
    private String lowestPz;
}
