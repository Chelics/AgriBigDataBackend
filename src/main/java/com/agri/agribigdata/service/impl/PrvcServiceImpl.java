package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.po.PrvcPO;
import com.agri.agribigdata.entity.vo.PrvcVO;
import com.agri.agribigdata.mapper.PrvcMapper;
import com.agri.agribigdata.service.PrvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrvcServiceImpl implements PrvcService {
    @Autowired
    PrvcMapper prvcMapper;

    @Override
    public PrvcVO getQuery(String name){
        return new PrvcVO(prvcMapper.getPrvcByName(name), prvcMapper.getCount(name));
    }
}
