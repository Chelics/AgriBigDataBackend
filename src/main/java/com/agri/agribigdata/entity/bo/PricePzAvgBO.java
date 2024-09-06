package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricePzAvgBO {
    private String market;
    private List<PriceMultiBO> price;

    public static List<PricePzAvgBO> transferOld2New(List<PricePzOldAvgBO> oldList){
        List<PricePzAvgBO> pricePzAvgBOList = new ArrayList<>();

        Map<String,List<PriceMultiBO>> newMap = new HashMap<>();
        for(PricePzOldAvgBO old: oldList){
            if(!newMap.containsKey(old.getMarket())){
                newMap.put(old.getMarket(), new ArrayList<>());
            }
            PriceMultiBO priceMultiBO = new PriceMultiBO();
            priceMultiBO.setAverage(old.getAverage());
            priceMultiBO.setReleaseTime(old.getReleaseTime());
            newMap.get(old.getMarket()).add(priceMultiBO);
        }

        for(String key: newMap.keySet()){
            List<PriceMultiBO> value = newMap.get(key);
            pricePzAvgBOList.add(new PricePzAvgBO(key, value));
        }

        return pricePzAvgBOList;
    }
}
