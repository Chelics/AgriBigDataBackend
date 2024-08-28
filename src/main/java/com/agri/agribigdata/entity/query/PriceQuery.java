package com.agri.agribigdata.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceQuery {
    private Integer pzId;
    private Integer marketId;
    private Integer prvcId;
    private boolean isToday;
}
