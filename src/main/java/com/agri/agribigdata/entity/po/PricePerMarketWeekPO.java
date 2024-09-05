package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePerMarketWeekPO {
    private String market;
    private String maxPz;
    private Double maxPrice;
    private String maxDate;
    private String minPz;
    private Double minPrice;
    private String minDate;
}
