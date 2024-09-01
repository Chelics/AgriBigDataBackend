package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.bo.EnterpriseBriefBO;
import com.agri.agribigdata.entity.po.EnterprisePO;
import com.agri.agribigdata.entity.query.EnterpriseBriefQuery;
import com.agri.agribigdata.entity.query.MarketBriefQuery;
import com.agri.agribigdata.entity.vo.EnterpriseBriefVO;
import com.agri.agribigdata.entity.vo.MarketBriefVO;
import com.agri.agribigdata.mapper.BriefMapper;
import com.agri.agribigdata.service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefServiceImpl implements BriefService {
    @Autowired
    BriefMapper briefMapper;
    @Override
    public List<MarketBriefVO> getMarketBrief(MarketBriefQuery marketBriefQuery) {
        return briefMapper.getMarketByNameAndPrvc(marketBriefQuery);
    }

    @Override
    public EnterpriseBriefVO getEnterpriseBrief(EnterpriseBriefQuery enterpriseBriefQuery) {
        return new EnterpriseBriefVO(briefMapper.getEnterprise(EnterpriseBriefBO.TransferEnterpriseQuery2BO(enterpriseBriefQuery)), briefMapper.getEnterpriseCount(enterpriseBriefQuery));
    }
}
