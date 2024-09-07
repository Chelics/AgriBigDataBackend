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
public class PriceMarketAvgBO {
    private String pz;
    private List<PriceMultiBO> price;

    public static List<PriceMarketAvgBO> transferOld2New(List<PriceMarketOldAvgBO> oldList){
        List<PriceMarketAvgBO> priceMarketAvgBOList = new ArrayList<>();

        Map<String,List<PriceMultiBO>> newMap = new HashMap<>();
        for(PriceMarketOldAvgBO old: oldList){
            if (!newMap.containsKey(old.getPz())) {
                newMap.put(old.getPz(), new ArrayList<>());
            }
            PriceMultiBO priceMultiBO = new PriceMultiBO(old.getReleaseTime(),old.getAverage());
            newMap.get(old.getPz()).add(priceMultiBO);
        }

        for (String key : newMap.keySet()) {
            List<PriceMultiBO> value = newMap.get(key);
            priceMarketAvgBOList.add(new PriceMarketAvgBO(key,value));
        }

        return priceMarketAvgBOList;
    }
}
