package com.agri.agribigdata.mapper;

import java.util.List;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import org.apache.ibatis.annotations.*;

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

    @Update("update user set prvc_id = #{prvcId} where id = #{userId}")
    void setPrcv(String userId, String prvcId);

    @Insert("insert into user_pz(user_id, pz_id) values (#{userId},#{pzId})")
    void setPz(String userId, String pzId);

    @Select("select id from user where username=#{username}")
    String getIdByUsername(String username);

    @Delete("delete from user_pz where user_id = #{userId}")
    void clearPersonalPz(String userId);

}
