package com.agri.agribigdata.entity.vo;


import com.agri.agribigdata.entity.po.MarketPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketVO {
    private List<MarketPO> marketList;
    private Integer count;
}
