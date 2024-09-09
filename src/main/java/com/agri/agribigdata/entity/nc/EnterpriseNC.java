package com.agri.agribigdata.entity.nc;

import com.agri.agribigdata.entity.po.EnterprisePO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnterpriseNC {
    private List<ArrayList<EnterprisePO>> enterpriseList;

    private Integer count;
}
