package com.mymaven.MyMaven.mapper;

import java.util.List;

import com.mymaven.MyMaven.model.User;

public interface UserMapper {
    //根据id查询用户
    public User selectUserById(long id);
    //根据姓名模糊查询用户
    public List<User> selectUserByName(String name);
    //插入一个用户,返回受影响的行数
    public int insertUser(User user);
    //删除一个用户,返回受影响的行数
    public int deleteUser(long id);
    //更新一个用户,返回受影响的行数
    public int updateUser(User user);
}
