package com.myannotation.dao;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myannotation.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ApplicationContext.xml"})
public class UserDaoTest {

	static Logger logger = Logger.getLogger(UserDaoTest.class);
	
    //对ctx进行标注，完成自动配装的工作
    @Autowired
    ApplicationContext ctx;
	
    //所有测试开始前执行
    @BeforeClass
    public static void begin(){
        logger.info("测试开始");
    }

    //所有测试完成后执行
    @AfterClass
    public static void end(){
        logger.info("测试结束");
    }
    
	@Test
	public void testStudySelect() {
        try {
            logger.info("测试查找\n");
            //getBean() 方法得到所需要的 bean
            UserDao userDao = ctx.getBean(UserDao.class);
            User user = userDao.studySelect(9);
            logger.info("输出查询结果\n" + user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查找出错： " + e.getMessage());
        }
	}

	@Test
	public void testStudyInsert() {
		try{
			UserDao userDao = ctx.getBean(UserDao.class);
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
	        int index = userDao.studyInsert(user);
	        logger.info("受影响的行数"+index);//获取受影响的行数
	        logger.info(user.getId());//获取返回的自增主键
		}catch (Exception e){
            e.printStackTrace();
            logger.error("增加出错： " + e.getMessage());
        }
	}

	@Test
	public void testStudyUpdate() {
		try{
			UserDao userDao = ctx.getBean(UserDao.class);
	        User user = new User();
			user.setId(5);
	        user.setName("燕小鱼");
	        boolean index = userDao.studyUpdate(user);
	        logger.info("修改结果"+index);//获取受影响的行数
		}catch (Exception e){
            e.printStackTrace();
            logger.error("修改出错： " + e.getMessage());
        }
	}

	@Test
	public void testStudyDelete() {
		try{
			UserDao userDao = ctx.getBean(UserDao.class);
	        boolean index = userDao.studyDelete(99);
	        logger.info("删除结果"+index);//获取受影响的行数
		}catch (Exception e){
            e.printStackTrace();
            logger.error("删除出错： " + e.getMessage());
        }
	}

	@Ignore
	@Test
	public void testStudentName() {

	        logger.info("忽略该测试");

	}

}
