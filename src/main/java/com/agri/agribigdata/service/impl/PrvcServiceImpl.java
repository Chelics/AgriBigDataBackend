package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.mapper.PrvcMapper;
import com.agri.agribigdata.service.PrvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrvcServiceImpl implements PrvcService {
    @Autowired
    PrvcMapper prvcMapper;

    @Override
    public List<String> getQuery(String name){
        return prvcMapper.getPrvcByName(name);
    }
}
