package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.query.MarketPriceQuery;
import com.agri.agribigdata.entity.query.PriceTopQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.PriceTopFallVO;
import com.agri.agribigdata.entity.vo.PriceTopRiseVO;
import com.agri.agribigdata.entity.vo.PriceVO;
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
        return new PriceVO(priceMapper.getPrice(priceBO), priceMapper.getPriceCount(priceBO));
    }
}
