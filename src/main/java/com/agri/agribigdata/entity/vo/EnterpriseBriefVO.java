package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.po.EnterprisePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseBriefVO {
    private List<EnterprisePO> enterpriseList;
    private Integer count;
}
