package com.agri.agribigdata.entity.vo;


import com.agri.agribigdata.entity.po.PrvcPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PrvcVO {
    private List<PrvcPO> prvcList;
    private Integer count;
}
