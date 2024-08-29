package com.agri.agribigdata.service;

import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.PzVO;

public interface PzService {
    PzVO getQuery(PzQuery pzQuery);
}
