package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.bo.PriceAvgBO;
import com.agri.agribigdata.entity.bo.PricePartialHBO;
import com.agri.agribigdata.entity.bo.PricePartialLBO;
import com.agri.agribigdata.entity.po.PricePO;
import com.agri.agribigdata.entity.po.PricePerPzWeekPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePartialVO {
    private PricePartialHBO highestInfo;
    private PricePartialLBO lowestInfo;
    private List<PriceAvgBO> averageInfo;

    public static PricePartialVO transfer(PricePerPzWeekPO pricePerPzWeekPO,List<PricePO> pricePOS){
        PricePartialVO pricePartialVO = new PricePartialVO();
        pricePartialVO.highestInfo = new PricePartialHBO();
        pricePartialVO.lowestInfo = new PricePartialLBO();
        pricePartialVO.highestInfo.setHighest(pricePerPzWeekPO.getMaxPrice());
        pricePartialVO.highestInfo.setMarket(pricePerPzWeekPO.getMaxMarket());
        pricePartialVO.highestInfo.setReleaseTime(pricePerPzWeekPO.getMaxDate());
        pricePartialVO.lowestInfo.setLowest(pricePerPzWeekPO.getMinPrice());
        pricePartialVO.lowestInfo.setMarket(pricePerPzWeekPO.getMinMarket());
        pricePartialVO.lowestInfo.setReleaseTime(pricePerPzWeekPO.getMinDate());
        List<PriceAvgBO> priceAvgBOArrayList= new ArrayList<>();
        for (PricePO pricePO : pricePOS) {
            PriceAvgBO priceAvgBO = new PriceAvgBO();
            priceAvgBO.setAverage(pricePO.getAverage());
            priceAvgBO.setReleaseTime(pricePO.getReleaseTime());
            priceAvgBOArrayList.add(priceAvgBO);
        }
        pricePartialVO.averageInfo = priceAvgBOArrayList;
        return pricePartialVO;
    }
}
