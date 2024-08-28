package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.bo.PriceBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceVO {
    private List<PriceBO> priceList;
    private Integer count;
}
