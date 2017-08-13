package com.mymaven.mapper;

import com.mymaven.model.User;

import java.util.List;

public interface UserMapper {
    //根据id查询用户
    public User selectUserById(long id);
    //根据姓名模糊查询用户
    public List<User> selectUserByName(String name);
    //根据学号模糊查询用户
    public List<User> selectUserBystudentNumber(int studentnumber);
    //插入一个用户,返回受影响的行数
    public int insertUser(User user);
    //删除一个用户,返回受影响的行数
    public boolean deleteUser(long id);
    //更新一个用户,返回受影响的行数
    public boolean updateUser(User user);
}
