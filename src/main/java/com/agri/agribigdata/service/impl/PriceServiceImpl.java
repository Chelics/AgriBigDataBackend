package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.po.*;
import com.agri.agribigdata.entity.query.*;
import com.agri.agribigdata.entity.vo.*;
import com.agri.agribigdata.mapper.PriceMapper;
import com.agri.agribigdata.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceMapper priceMapper;

    @Override
    public List<String> getMarketList(MarketPriceQuery marketPriceQuery) {
        return priceMapper.getMarketByPrvcAndName(marketPriceQuery);
    }

    @Override
    public List<String> getPzList(PzQuery pzQuery) {
        return priceMapper.getPz(pzQuery);
    }

    @Override
    public List<PriceTopRiseVO> getTopRise(PriceTopQuery priceTopQuery) {
        return priceMapper.getTopRise(priceTopQuery);
    }

    @Override
    public List<PriceTopFallVO> getTopFall(PriceTopQuery priceTopQuery) {
        return priceMapper.getTopFall(priceTopQuery);
    }

    @Override
    public PriceVO getPrice(PriceBO priceBO) {
        return new PriceVO(priceMapper.getPriceByPriceBO(priceBO), priceMapper.getPriceCount(priceBO));
    }

    @Override
    public List<IndexVO> getTwoIndex() {
        return IndexVO.transferIndexP2V(priceMapper.getTwoIndex());
    }

    @Override
    public List<IndexVO> getHbIndex() {
        return IndexVO.transferIndexP2V(priceMapper.getHbIndex());
    }

    @Override
    public PricePartialVO getSinglePzPartialPrice(PricePartialQuery pricePartialQuery){
        PricePerPzWeekPO pricePerPzWeekPO = priceMapper.getPerPzWeekPartialHL(pricePartialQuery);
        List<PricePO> pricePOList = priceMapper.getPriceByPz(pricePartialQuery);
        PricePartialVO pricePartialVO = PricePartialVO.transfer(pricePerPzWeekPO,pricePOList);
        return pricePartialVO;
    }

    @Override
    public PriceSingleMarketVO getSingleMarketPrice(PriceSingleMarketQuery priceSingleMarketQuery) {
        PricePerMarketTodayPO pricePerMarketTodayPO = priceMapper.getPerMarketTodayPrice(priceSingleMarketQuery);
        PricePerMarketWeekPO pricePerMarketWeekPO = priceMapper.getPerMarketWeekPrice(priceSingleMarketQuery);
        List<PricePO> pricePOList = priceMapper.getPriceByPzList(priceSingleMarketQuery);
        return PriceSingleMarketVO.transfer(pricePerMarketTodayPO,pricePerMarketWeekPO,pricePOList);
    }

    @Override
    public PriceSinglePzVO getSinglePzPrice(PriceSinglePzQuery priceSinglePzQuery) {
        PricePerPzTodayPO pricePerPzTodayPO = priceMapper.getPerPzTodayPrice(priceSinglePzQuery);
        PricePerPzWeekPO pricePerPzWeekPO = priceMapper.getPerPzWeekPrice(priceSinglePzQuery);
        List<PricePO> pricePOList = priceMapper.getPriceByMarketList(priceSinglePzQuery);
        return PriceSinglePzVO.transfer(pricePerPzTodayPO, pricePerPzWeekPO, pricePOList);
    }
}
