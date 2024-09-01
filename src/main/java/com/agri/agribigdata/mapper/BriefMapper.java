package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.bo.EnterpriseBriefBO;
import com.agri.agribigdata.entity.po.EnterprisePO;
import com.agri.agribigdata.entity.query.EnterpriseBriefQuery;
import com.agri.agribigdata.entity.query.MarketBriefQuery;
import com.agri.agribigdata.entity.vo.MarketBriefVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BriefMapper {


    List<MarketBriefVO> getMarketByNameAndPrvc(MarketBriefQuery marketBriefQuery);

    List<EnterprisePO> getEnterprise(EnterpriseBriefBO enterpriseBriefBO);

    @Select("select count(*) from enterprise")
    Integer getEnterpriseCount(EnterpriseBriefQuery enterpriseBriefQuery);
}
