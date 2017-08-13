package com.mymaven.mapper;

import com.mymaven.model.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {
	
    Logger logger = Logger.getLogger(UserMapperTest.class);
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        // 初始化Spring容器
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
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
            logger.info(user);
        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectUserBystudentNumber() {
		try
		{
	        // 获得代理对象
	        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
	        List<User> list = userMapper.selectUserBystudentNumber(2182);
	        for (User user : list) {
	        	logger.info(user);
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
        user.setGraduateSchool("北京天天蓝大学天天玩技术学院");
        user.setstudentNumber(0000);
        user.setDailyLink("http:www.jnshu.com");
        user.sethope("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！");
        user.setteacher("任我行");
        user.setknowFrom("知乎");
        user.setcreateAt(20170808);
        user.setupdateAt(20170808);
        
        int index = userMapper.insertUser(user);
        logger.info("受影响的行数"+index);//获取受影响的行数
        logger.info(user.getId());//获取返回的自增主键
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
        
        boolean index = userMapper.deleteUser(6);
        logger.info(index);//获取受影响的行数
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
        user.setGraduateSchool("北京天天蓝大学天天玩技术学院");
        user.setstudentNumber(0000);
        user.setDailyLink("http:www.jnshu.com");
        user.sethope("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！");
        user.setteacher("任我行");
        user.setknowFrom("知乎");
        user.setcreateAt(20170808);
        user.setupdateAt(20170808);
        
        boolean index = userMapper.updateUser(user);
        logger.info(index);
	} catch (Exception e) {
		e.printStackTrace();
	}
        //提交事务
        //applicationContext.commit();
	}

}
