package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.vo.DataVO;
import com.agri.agribigdata.entity.vo.SupplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {

    @Select("select * from catch_daily")
    DataVO getData();

    @Select("select * from supply_demand")
    List<SupplyVO> getSupplyData();
}
