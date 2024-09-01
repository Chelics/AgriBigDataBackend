package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.po.PricePO;
import com.agri.agribigdata.entity.query.MarketPriceQuery;
import com.agri.agribigdata.entity.query.PriceTopQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.IndexVO;
import com.agri.agribigdata.entity.vo.PriceTopFallVO;
import com.agri.agribigdata.entity.vo.PriceTopRiseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PriceMapper {
    List<String> getMarketByPrvcAndName(MarketPriceQuery marketPriceQuery);

    List<String> getPz(PzQuery pzQuery);

    List<PriceTopRiseVO> getTopRise(PriceTopQuery priceTopQuery);

    List<PriceTopFallVO> getTopFall(PriceTopQuery priceTopQuery);

    List<PricePO> getPrice(PriceBO priceBO);

    Integer getPriceCount(PriceBO priceBO);

    @Select("select * from price_index where type = 2")
    IndexVO getTwoIndex();

    @Select("select * from price_index where type = 1")
    IndexVO getHbIndex();
}
