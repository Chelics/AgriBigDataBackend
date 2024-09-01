package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.vo.DataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapper {

    @Select("select * from catch_daily")
    DataVO getData();
}
