package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.bo.*;
import com.agri.agribigdata.entity.po.PricePO;
import com.agri.agribigdata.entity.po.PricePerPzTodayPO;
import com.agri.agribigdata.entity.po.PricePerPzWeekPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceSinglePzVO {
    private PricePzTodayBO todayInfo;
    private PricePzWeekBO weekInfo;
    private List<PricePzAvgBO> averageInfo;

    public static PriceSinglePzVO transfer(PricePerPzTodayPO pricePerPzTodayPO, PricePerPzWeekPO pricePerPzWeekPO, List<PricePO> pricePOList){
        PricePzTodayBO todayInfo = new PricePzTodayBO();
        PricePzWeekBO weekInfo = new PricePzWeekBO();

        todayInfo.setHighest(pricePerPzTodayPO.getMaxPrice());
        todayInfo.setHighestMarket(pricePerPzTodayPO.getMaxMarket());
        todayInfo.setLowest(pricePerPzTodayPO.getMinPrice());
        todayInfo.setLowestMarket(pricePerPzTodayPO.getMinMarket());

        weekInfo.setHighest(pricePerPzWeekPO.getMaxPrice());
        weekInfo.setHighestReleaseTime(pricePerPzWeekPO.getMaxDate());
        weekInfo.setHighestMarket(pricePerPzWeekPO.getMaxMarket());
        weekInfo.setLowest(pricePerPzWeekPO.getMinPrice());
        weekInfo.setLowestReleaseTime(pricePerPzWeekPO.getMinDate());
        weekInfo.setLowestMarket(pricePerPzWeekPO.getMinMarket());

        List<PricePzOldAvgBO> pricePzOldAvgBOList = new ArrayList<>();
        for (PricePO pricePO : pricePOList) {
            PricePzOldAvgBO pricePzOldAvgBO = new PricePzOldAvgBO();
            pricePzOldAvgBO.setReleaseTime(pricePO.getReleaseTime());
            pricePzOldAvgBO.setAverage(pricePO.getAverage());
            pricePzOldAvgBO.setMarket(pricePO.getMarket());
            pricePzOldAvgBOList.add(pricePzOldAvgBO);
        }

        List<PricePzAvgBO> pricePzAvgBOList = PricePzAvgBO.transferOld2New(pricePzOldAvgBOList);

        return new PriceSinglePzVO(todayInfo, weekInfo, pricePzAvgBOList);
    }
}
