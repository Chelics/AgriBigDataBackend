package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.bo.PriceAvgBO;
import com.agri.agribigdata.entity.bo.PriceMarketAvgBO;
import com.agri.agribigdata.entity.bo.PriceMarketTodayBO;
import com.agri.agribigdata.entity.bo.PriceMarketWeekBO;
import com.agri.agribigdata.entity.po.PricePO;
import com.agri.agribigdata.entity.po.PricePerMarketTodayPO;
import com.agri.agribigdata.entity.po.PricePerMarketWeekPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceSingleMarketVO {
    private PriceMarketTodayBO todayInfo;
    private PriceMarketWeekBO weekInfo;
    private List<PriceMarketAvgBO> averageInfo;

    public static PriceSingleMarketVO transfer(PricePerMarketTodayPO pricePerMarketTodayPO, PricePerMarketWeekPO pricePerMarketWeekPO, List<PricePO> pricePOList){
        PriceMarketTodayBO todayInfo = new PriceMarketTodayBO();
        PriceMarketWeekBO weekInfo = new PriceMarketWeekBO();

        todayInfo.setHighest(pricePerMarketTodayPO.getMaxPrice());
        todayInfo.setHighestPz(pricePerMarketTodayPO.getMaxPz());
        todayInfo.setLowest(pricePerMarketTodayPO.getMinPrice());
        todayInfo.setLowestPz(pricePerMarketTodayPO.getMinPz());

        weekInfo.setHighest(pricePerMarketWeekPO.getMaxPrice());
        weekInfo.setHighestPz(pricePerMarketWeekPO.getMaxPz());
        weekInfo.setHighestReleaseTime(pricePerMarketWeekPO.getMaxDate());
        weekInfo.setLowest(pricePerMarketWeekPO.getMinPrice());
        weekInfo.setLowestPz(pricePerMarketWeekPO.getMinPz());
        weekInfo.setLowestReleaseTime(pricePerMarketWeekPO.getMinDate());

        List<PriceMarketAvgBO> priceMarketAvgBOList = new ArrayList<>();
        for (PricePO pricePO : pricePOList) {
            PriceMarketAvgBO priceMarketAvgBO = new PriceMarketAvgBO();
            priceMarketAvgBO.setPz(pricePO.getPz());
            priceMarketAvgBO.setReleaseTime(pricePO.getReleaseTime());
            priceMarketAvgBO.setAverage(pricePO.getAverage());
            priceMarketAvgBOList.add(priceMarketAvgBO);
        }

       return new PriceSingleMarketVO(todayInfo,weekInfo,priceMarketAvgBOList);
    }
}
