package com.agri.agribigdata.service;

import com.agri.agribigdata.entity.query.EnterpriseBriefQuery;
import com.agri.agribigdata.entity.query.MarketBriefQuery;
import com.agri.agribigdata.entity.vo.EnterpriseBriefVO;
import com.agri.agribigdata.entity.vo.MarketBriefVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BriefService {
    List<MarketBriefVO> getMarketBrief(MarketBriefQuery marketBriefQuery);

    EnterpriseBriefVO getEnterpriseBrief(EnterpriseBriefQuery enterpriseBriefQuery);

}
