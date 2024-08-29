package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.vo.PzVO;
import com.agri.agribigdata.mapper.PzMapper;
import com.agri.agribigdata.service.PzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PzServiceImpl implements PzService {
    @Autowired
    PzMapper pzMapper;

    @Override
    public PzVO getQuery(String name){
        return new PzVO(pzMapper.getPzs(name), pzMapper.getCount(name));
    }
}
