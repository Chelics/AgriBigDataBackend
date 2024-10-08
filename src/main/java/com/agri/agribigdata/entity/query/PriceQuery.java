package com.agri.agribigdata.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceQuery {
    private String pz;
    private String market;
    private String prvc;
    private String startDate;
    private String endDate;
    private Integer pageSize = 10;
    private Integer pageNum = 1;
}
