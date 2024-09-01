package com.agri.agribigdata.service;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.query.MarketPriceQuery;
import com.agri.agribigdata.entity.query.PriceTopQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.PriceTopFallVO;
import com.agri.agribigdata.entity.vo.PriceTopRiseVO;
import com.agri.agribigdata.entity.vo.PriceVO;
import com.agri.agribigdata.entity.vo.IndexVO;

import java.util.List;

public interface PriceService {
    List<String> getMarketList(MarketPriceQuery marketPriceQuery);

    List<String> getPzList(PzQuery pzQuery);

    List<PriceTopRiseVO> getTopRise(PriceTopQuery priceTopQuery);

    List<PriceTopFallVO> getTopFall(PriceTopQuery priceTopQuery);

    PriceVO getPrice(PriceBO priceBO);

    IndexVO getTwoIndex();

    IndexVO getHbIndex();
}
