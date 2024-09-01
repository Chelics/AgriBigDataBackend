package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.vo.DataVO;
import com.agri.agribigdata.mapper.DataMapper;
import com.agri.agribigdata.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    DataMapper dataMapper;

    @Override
    public DataVO getData() {
        return dataMapper.getData();
    }
}
