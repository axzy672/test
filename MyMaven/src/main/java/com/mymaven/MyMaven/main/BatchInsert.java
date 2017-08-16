package com.mymaven.MyMaven.main;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.mymaven.MyMaven.mapper.UserMapper;
import com.mymaven.MyMaven.model.User;

public class BatchInsert {
public static void main(String[] args) {
	long startTime = System.currentTimeMillis();    //获取开始时间
	
	//获取sqlsession
	//从spring注入原有的sqlSessionTemplate

	SqlSessionTemplate sqlSessionTemplate = null;
	// 新获取一个模式为BATCH，自动提交为false的session
	// 如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
	SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
	//通过新的session获取mapper
	UserMapper userMapper = session.getMapper(UserMapper.class);
	int size = 10000;
	try{
	for(int i = 0; i < size; i++) {
		User user = new User();
        user.setName("李小"+i);
        user.setQq(00000000+i);
        user.settype("前端工程师");
        user.settime(20170708);
        user.setGraduate_School("北京天天蓝大学天天玩技术学院");
        user.setstudent_number(i);
        user.setDaily_link("http:www.jnshu.com");
        user.sethope("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！");
        user.setteacher("任我行");
        user.setknow_from("知乎");
        user.setcreate_at(20170808);
        user.setupdate_at(20170808);
        userMapper.insertUser(user);
	if(i % 1000 == 0 || i == size - 1) {
	//手动每1000个一提交，提交后无法回滚 
	session.commit();
	//清理缓存，防止溢出
	session.clearCache();
	}
	}
	} catch (Exception e) {
	//没有提交的数据可以回滚
	session.rollback();
	} finally{
	session.close();
	}
	long endTime = System.currentTimeMillis();    //获取结束时间
	System.out.println("插入"+ size +"条数据");
	System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
}

}
