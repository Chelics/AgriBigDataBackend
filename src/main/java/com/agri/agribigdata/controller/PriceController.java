package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.query.MarketPriceQuery;
import com.agri.agribigdata.entity.query.PriceQuery;
import com.agri.agribigdata.entity.query.PriceTopQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PriceController {
    @Autowired
    PriceService priceService;
    @PostMapping("/price/market")
    public ResultVO getMarket(@RequestBody MarketPriceQuery marketPriceQuery){
        return ResultVO.success(priceService.getMarketList(marketPriceQuery));
    }

    @PostMapping("/price/pz")
    public ResultVO getPz(@RequestBody PzQuery pzQuery){
        return ResultVO.success(priceService.getPzList(pzQuery));
    }

    @PostMapping("/price/rise")
    public ResultVO getTopRise(@RequestBody PriceTopQuery priceTopQuery){
        if(priceTopQuery.getPrvc().equals("")){
            priceTopQuery.setPrvc("全国");
        }
        return ResultVO.success(priceService.getTopRise(priceTopQuery));
    }

    @PostMapping("/price/fall")
    public ResultVO getTopFall(@RequestBody PriceTopQuery priceTopQuery){
        if(priceTopQuery.getPrvc().equals("")){
            priceTopQuery.setPrvc("全国");
        }
        return ResultVO.success(priceService.getTopFall(priceTopQuery));
    }

    @PostMapping("/price")
    public ResultVO getPrice(@RequestBody PriceQuery priceQuery){
        return ResultVO.success(priceService.getPrice(PriceBO.TransferQuery2BO(priceQuery)));
    }
}
