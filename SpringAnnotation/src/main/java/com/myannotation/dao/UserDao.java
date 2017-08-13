package com.myannotation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myannotation.model.User;

public interface UserDao {
    @Select("SELECT*From apply WHERE student_number = #{studentNumber}")
    User studySelect(int studentNumber);

    @Insert(" INSERT INTO apply (Name,Qq,type,time,Graduate_School,student_number,Daily_link,hope,teacher,know_from,create_at,update_at)"
    		+ "VALUES (#{Name},#{Qq},#{type},#{time},#{Graduate_School},#{student_number},#{Daily_link},#{hope},#{teacher},#{know_from},#{create_at},#{update_at})")
    int studyInsert(User user);

    @Update("UPDATE apply SET Name=#{Name} WHERE Id=#{Id}")
    boolean studyUpdate(User user);

    @Delete("DELETE FROM apply WHERE Id=#{Id}")
    boolean studyDelete(long id);

    @Select("SELECT (Name,Qq,type,time,Graduate_School,student_number,Daily_link,hope,teacher,know_from,create_at,update_at FROM apply")
    List<User> studentName();
}
