package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.po.PzPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PzVO {
    private List<PzPO> pzList;
    private Integer count;
}
