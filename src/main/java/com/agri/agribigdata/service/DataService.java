package com.agri.agribigdata.service;

import com.agri.agribigdata.entity.vo.DataVO;
import com.agri.agribigdata.entity.vo.SupplyVO;
import java.util.List;

public interface DataService {

    DataVO getData();

    List<SupplyVO> getSupplyData();
}
