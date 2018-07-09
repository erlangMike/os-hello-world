package com.crrc.platform.hello.mapper;

import com.crrc.platform.hello.model.JsSysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author mikejn
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM JS_SYS_USER")
    List<JsSysUser> getAll();

    @Select("SELECT * FROM JS_SYS_USER WHERE userCode = #{userCode}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    JsSysUser getOne(String userCode);

    @Insert("INSERT INTO JS_SYS_USER(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(JsSysUser user);

    @Update("UPDATE JS_SYS_USER SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(JsSysUser user);

    @Delete("DELETE FROM JS_SYS_USER WHERE userCode =#{userCode}")
    void delete(Long id);

}
