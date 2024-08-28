package com.agri.agribigdata.mapper;


import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password} ")
    UserBO getByUsernameAndPassword(UserPQuery userPQuery) ;
}
