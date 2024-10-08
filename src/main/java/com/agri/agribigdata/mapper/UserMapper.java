package com.agri.agribigdata.mapper;

import java.util.List;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.po.UserPO;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.entity.query.UserVQuery;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user(id, username, password, tel, email) values (#{id}, #{username}, #{password}, #{tel}, #{email})")
    void register(UserBO userBO);

    @Select("select * from user where username=#{username}")
    UserPO getByUsername(UserPQuery userPQuery) ;

    @Select("select * from user where email = #{email}")
    UserBO getByEmail(UserVQuery userVQuery);

    @Select("select * from user where tel = #{tel}")
    UserBO getByTel(UserVQuery userVQuery);

    @Select("select count(*) from user where username=#{username}")
    boolean checkDoubleUsername(UserBO userBO);

    @Select("select count(*) from user where tel=#{tel}")
    boolean checkDoubleTel(UserBO userBO);

    @Select("select count(*) from user where email=#{email}")
    boolean checkDoubleEmail(UserBO userBO);

    @Update("update user set prvc = #{prvcId} where id = #{userId}")
    void setPrcv(String userId, String prvcId);

    @Insert("insert into user_pz(user_id, pz) values (#{userId},#{pz})")
    void setPz(String userId, String pz);

    @Select("select id from user where username=#{username}")
    String getIdByUsername(String username);

    @Delete("delete from user_pz where user_id = #{userId}")
    void clearPersonalPz(String userId);

    @Update("update user set verify_code = #{code}, verify_time = #{time} where email = #{email}")
    void updateVerifyInfoByEmail(String code, String time, String email);

    @Update("update user set verify_code = #{code}, verify_time = #{time} where tel = #{tel}")
    void updateVerifyInfoByTel(String code, String time, String tel);

    @Select("select pz from user_pz  where user_id = #{id}")
    List<String> getInterestedPzList(String id);
    @Select("select prvc from user  where username = #{username}")
    String getPrvcByUsername(String username);
}
