package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.po.PrvcPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PrvcMapper {


    List<PrvcPO> getPrvcByName(String name);

    Integer getCount(String name);
}
