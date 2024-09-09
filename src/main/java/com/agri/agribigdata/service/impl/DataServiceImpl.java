package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.vo.DataVO;
import com.agri.agribigdata.entity.vo.SupplyVO;
import com.agri.agribigdata.mapper.DataMapper;
import com.agri.agribigdata.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    DataMapper dataMapper;

    @Override
    public DataVO getData() {
        return dataMapper.getData();
    }

    @Override
    public List<SupplyVO> getSupplyData() {
        return dataMapper.getSupplyData();
    }
}
