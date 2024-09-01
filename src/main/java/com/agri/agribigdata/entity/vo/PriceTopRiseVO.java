package com.agri.agribigdata.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceTopRiseVO {
    private String prvc;
    private String pz;
    private Double price;
    private Double rise;
}
