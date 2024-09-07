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
public class PricePartialAvgBO {
    private String prvc;
    private List<PriceMultiBO> price;

    public static List<PricePartialAvgBO> transfer(List<PriceAvgBO> oldList){
        List<PricePartialAvgBO> pricePartialAvgBOList = new ArrayList<>();

        Map<String,List<PriceMultiBO>> newMap = new HashMap<>();
        for(PriceAvgBO old: oldList){
            if(!newMap.containsKey(old.getPrvc())){
                newMap.put(old.getPrvc(), new ArrayList<>());
            }
            PriceMultiBO priceMultiBO = new PriceMultiBO(old.getReleaseTime(), old.getAverage());
            newMap.get(old.getPrvc()).add(priceMultiBO);
        }

        for(String key: newMap.keySet()){
            List<PriceMultiBO> value = newMap.get(key);
            pricePartialAvgBOList.add(new PricePartialAvgBO(key,value));
        }

        return pricePartialAvgBOList;
    }
}
