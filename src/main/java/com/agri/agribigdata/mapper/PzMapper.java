package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.po.PzPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PzMapper {

    List<PzPO> getPzs(String keyword);

    Integer getCount(String keyword);

}
