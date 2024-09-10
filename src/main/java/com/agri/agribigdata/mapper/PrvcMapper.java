package com.agri.agribigdata.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrvcMapper {
    List<String> getPrvcByName(String name);
}
