package com.agri.agribigdata.service;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.query.*;
import com.agri.agribigdata.entity.vo.*;
import com.agri.agribigdata.exception.CustomException;

import java.util.List;

public interface PriceService {
    List<String> getMarketList(MarketPriceQuery marketPriceQuery);

    List<String> getPzList(PzQuery pzQuery);

    List<PriceTopRiseVO> getTopRise(PriceTopQuery priceTopQuery);

    List<PriceTopFallVO> getTopFall(PriceTopQuery priceTopQuery);

    PriceVO getPrice(PriceBO priceBO);

    IndexVO getTwoIndex();

    IndexVO getHbIndex();

    PricePartialVO getSinglePzPartialPrice(PricePartialQuery pricePartialQuery);

    PriceSingleMarketVO getSingleMarketPrice(PriceSingleMarketQuery priceSingleMarketQuery);

    PriceSinglePzVO getSinglePzPrice(PriceSinglePzQuery priceSinglePzQuery);
}
