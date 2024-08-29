package com.agri.agribigdata.mapper;


import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(id, username, password, tel, email) values (#{id}, #{username}, #{password}, #{tel}, #{email})")
    void register(UserBO userBO);

    @Select("select * from user where username=#{username} and password=#{password}")
    UserBO getByUsernameAndPassword(UserPQuery userPQuery) ;

    @Select("select count(*) from user where username=#{username}")
    boolean checkDoubleUsername(UserBO userBO);

    @Select("select count(*) from user where tel=#{tel}")
    boolean checkDoubleTel(UserBO userBO);

    @Select("select count(*) from user where email=#{email}")
    boolean checkDoubleEmail(UserBO userBO);

}
