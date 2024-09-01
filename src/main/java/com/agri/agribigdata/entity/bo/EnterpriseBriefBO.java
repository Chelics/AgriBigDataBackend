package com.agri.agribigdata.entity.bo;

import com.agri.agribigdata.entity.query.EnterpriseBriefQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseBriefBO {
    private String prvc = null;
    private String pz = null;
    private String supplyType = null;
    private Integer pageSize = 10;
    private Integer offset = 1;

    public static EnterpriseBriefBO TransferEnterpriseQuery2BO(EnterpriseBriefQuery enterpriseBriefQuery){
        EnterpriseBriefBO enterpriseBriefBO = new EnterpriseBriefBO();
        enterpriseBriefBO.setPrvc(enterpriseBriefQuery.getPrvc());
        enterpriseBriefBO.setPz(enterpriseBriefQuery.getPz());
        enterpriseBriefBO.setPageSize(enterpriseBriefQuery.getPageSize());
        enterpriseBriefBO.setOffset(enterpriseBriefQuery.getPageSize()*(enterpriseBriefQuery.getPageNum()-1));
        return enterpriseBriefBO;
    }
}
