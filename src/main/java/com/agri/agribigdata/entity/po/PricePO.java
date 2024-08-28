package com.agri.agribigdata.entity.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePO {
    private Integer id;
    private Integer pzId;
    private Integer marketId;
    private Integer prvcId;
    private Date date;
    private Double highest;
    private Double lowest;
    private Double average;
    private Double salesVolume;
    private Double hb;
    private Double rise;
    private Double increment;
    private Double total;

}
