package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.po.*;
import com.agri.agribigdata.entity.query.*;
import com.agri.agribigdata.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PriceMapper {
    List<String> getMarketByPrvcAndName(MarketPriceQuery marketPriceQuery);

    List<String> getPz(PzQuery pzQuery);

    List<PriceTopRiseVO> getTopRise(PriceTopQuery priceTopQuery);

    List<PriceTopFallVO> getTopFall(PriceTopQuery priceTopQuery);

    List<PricePO> getPriceByPriceBO(PriceBO priceBO);

    List<PricePO> getPriceByPz(PricePartialQuery pricePartialQuery);

    Integer getPriceCount(PriceBO priceBO);

    @Select("select * from price_index where index_type = 2")
    List<IndexPO> getTwoIndex();

    @Select("select * from price_index where index_type = 1")
    List<IndexPO> getHbIndex();


    PricePerPzTodayPO getPerPzTodayNational(PricePartialQuery pricePartialQuery);
    PricePerPzWeekPO getPerPzWeekPartialHL(PricePartialQuery pricePartialQuery);

    PricePerMarketTodayPO getPerMarketTodayPrice(PriceSingleMarketQuery priceSingleMarketQuery);

    List<PricePO> getPriceByPzList(PriceSingleMarketQuery priceSingleMarketQuery);

    PricePerMarketWeekPO getPerMarketWeekPrice(PriceSingleMarketQuery priceSingleMarketQuery);

    PricePerPzTodayPO getPerPzTodayPrice(PriceSinglePzQuery priceSinglePzQuery);

    PricePerPzWeekPO getPerPzWeekPrice(PriceSinglePzQuery priceSinglePzQuery);

    List<PricePO> getPriceByMarketList(PriceSinglePzQuery priceSinglePzQuery);
}
