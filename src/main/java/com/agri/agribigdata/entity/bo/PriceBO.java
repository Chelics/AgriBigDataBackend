package com.agri.agribigdata.entity.bo;

import com.agri.agribigdata.entity.query.PriceQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceBO {
    private String pz;
    private String market;
    private String prvc;
    private String startDate;
    private String endDate;
    private Integer pageSize;
    private Integer offset;

    public static PriceBO TransferQuery2BO(PriceQuery priceQuery){
        PriceBO priceBO = new PriceBO();
        priceBO.setPz(priceQuery.getPz());
        priceBO.setPrvc(priceQuery.getPrvc());
        priceBO.setMarket(priceQuery.getMarket());
        priceBO.setStartDate(priceQuery.getStartDate());
        priceBO.setEndDate(priceQuery.getEndDate());
        priceBO.setPageSize(priceQuery.getPageSize());
        priceBO.setOffset((priceQuery.getPageNum()-1)* priceQuery.getPageSize());
        return priceBO;
    }
}
