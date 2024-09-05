package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePerPzTodayPO {
    private String pz;
    private String prvc;
    private String maxMarket;
    private Double maxPrice;
    private String minMarket;
    private Double minPrice;
}
