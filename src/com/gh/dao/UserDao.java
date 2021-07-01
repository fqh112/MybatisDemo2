package com.gh.dao;

import com.gh.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    List<User> findUserAndScore() throws Exception;

    List<User> findUserIn(List<Integer> list) throws Exception;

    List<User> findUserLimit(List<Integer> list) throws Exception;

    List<User> findUserBetween(List<Integer> list) throws Exception;

    List<User> findUserByNameAndSex(User user) throws Exception;

    List<User> findUserByNameAndId(User user) throws Exception;

    List<User> findById(@Param("id") Integer id);

    @Delete("delete from user where id = #{id}")
    void deleteById(@Param("id") Integer id);

    @Insert("insert into user values(null,#{user.name},#{user.age},#{user.sex},#{user.address})")
    void insertInfo(@Param("user") User user);

}
