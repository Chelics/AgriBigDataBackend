package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.query.*;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
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

    @GetMapping("/price/twoindex")
    public ResultVO getTwoIndex(){
        return ResultVO.success(priceService.getTwoIndex());
    }

    @GetMapping("/price/hbindex")
    public ResultVO getHbIndex(){
        return ResultVO.success(priceService.getHbIndex());
    }

    @PostMapping("/price/partial")
    public ResultVO getSinglePartialPrice(@RequestBody PricePartialQuery pricePartialQuery) throws CustomException {
        return ResultVO.success(priceService.getSinglePzPartialPrice(pricePartialQuery));
    }

    @PostMapping("/price/singlemarket")
    public ResultVO getSingleMarketPrice(@RequestBody PriceSingleMarketQuery priceSingleMarketQuery) throws CustomException {
        return ResultVO.success(priceService.getSingleMarketPrice(priceSingleMarketQuery));
    }

    @PostMapping("/price/singlepz")
    public ResultVO getSinglePzPrice(@RequestBody PriceSinglePzQuery priceSinglePzQuery) throws CustomException {
        return ResultVO.success(priceService.getSinglePzPrice(priceSinglePzQuery));
    }
}
