package com.mymaven.MyMaven.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mymaven.MyMaven.mapper.UserMapper;
import com.mymaven.MyMaven.model.User;



public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        // 初始化Spring容器
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
    }

	@Test
	public void testSelectUserById() {
		try {
        // 获得代理对象
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User user = userMapper.selectUserById(10);
        System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectUserByName() {
		try {
        // 获得代理对象(到时候就只需要通过Spring容器拿到UserMapper接口的代理对象就可以了)
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<User> list = userMapper.selectUserByName("%姚%");
        for (User user : list) {
            System.out.println(user);
        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertUser() {
		try {		        
        // 获得代理对象(到时候就只需要通过Spring容器拿到UserMapper接口的代理对象就可以了)
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        
        User user = new User();
        user.setName("燕小鱼");
        user.setQq(11111);
        user.settype("前端工程师");
        user.settime(20170708);
        user.setGraduate_School("北京天天蓝大学天天玩技术学院");
        user.setstudent_number(0000);
        user.setDaily_link("http:www.jnshu.com");
        user.sethope("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！");
        user.setteacher("任我行");
        user.setknow_from("知乎");
        user.setcreate_at(20170808);
        user.setupdate_at(20170808);
        
        int index = userMapper.insertUser(user);
        System.out.println("受影响的行数"+index);//获取受影响的行数
        System.out.println(user.getId());//获取返回的自增主键
		} catch (Exception e) {
			e.printStackTrace();
		}
        //提交事务
        //applicationContext.commit();
	}

	@Test
	public void testDeleteUser() {
		try {		       
        // 获得代理对象
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        
        int index = userMapper.deleteUser(6);
        System.out.println("受影响的行数"+index);//获取受影响的行数
		} catch (Exception e) {
			e.printStackTrace();
		}
        //提交事务
        //applicationContext.commit();
	}

	@Test
	public void testUpdateUser() {
		try {        
        // 获得代理对象(到时候就只需要通过Spring容器拿到UserMapper接口的代理对象就可以了)
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        
        User user = new User();
		user.setId(5);
        user.setName("燕小鱼");
        user.setQq(11111);
        user.settype("前端工程师");
        user.settime(20170708);
        user.setGraduate_School("北京天天蓝大学天天玩技术学院");
        user.setstudent_number(0000);
        user.setDaily_link("http:www.jnshu.com");
        user.sethope("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！");
        user.setteacher("任我行");
        user.setknow_from("知乎");
        user.setcreate_at(20170808);
        user.setupdate_at(20170808);
        
        int index = userMapper.updateUser(user);
        System.out.println("受影响的行数"+index);
	} catch (Exception e) {
		e.printStackTrace();
	}
        //提交事务
        //applicationContext.commit();
	}

}
