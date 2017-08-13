package com.mymaven.MyMaven.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsert 
{
public static void main(String[] args) 
 {  
	int a = 100;
	int b = 10000;
	
	long startTime = System.currentTimeMillis(); //获取开始时间
	
    String url = "jdbc:mysql://localhost:3306/first?characterEncoding=utf-8"; 
    String name = "com.mysql.jdbc.Driver"; 
    String user = "root"; 
    String password = "123456"; 
   Connection conn = null; 
   try {
       Class.forName(name);
       conn = DriverManager.getConnection(url, user, password);//获取连接
       conn.setAutoCommit(false);//关闭自动提交，不然conn.commit()运行到这句会报错
   } catch (ClassNotFoundException e1) {
       e1.printStackTrace();
   } catch (SQLException e) {
       e.printStackTrace();
   }
   
   // sql前缀
   String prefix = "INSERT INTO apply (Name,Qq,type,time,Graduate_School,student_number,Daily_link,hope,teacher,know_from,create_at,update_at) VALUES ";
   try {
	// 保存sql后缀
       StringBuffer suffix = new StringBuffer();
    // 设置事务为非自动提交
       conn.setAutoCommit(false);
       // 比起st，pst会更好些
       PreparedStatement  pst = (PreparedStatement) conn.prepareStatement("");//׼��ִ�����
       // 外层循环，总提交事务次数
       for (int i=1; i <= a; i++) {
           suffix = new StringBuffer();
           // 第j次提交步长
           for (int j=1; j <= b; j++) {
        	// 构建SQL后缀
               suffix.append("('李小"+i*j+"',"+i*j+",'前端工程师',20170708,'北京天天蓝大学天天玩技术学院',"+i*j+",'http:www.jnshu.com','如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！','任我行','知乎',20170812,20170812),");
           }
        // 构建完整SQL
           String sql = prefix + suffix.substring(0, suffix.length() - 1);
        // 添加执行SQL
           pst.addBatch(sql);
        // 执行操作
           pst.executeBatch();
           // 提交事务
           conn.commit();
           // 清空上一次添加的数据
           suffix = new StringBuffer();
       }
    // 头等连接
       pst.close();
       conn.close();
   } catch (SQLException e) {
       e.printStackTrace();
   }
   
	long endTime = System.currentTimeMillis();    //获取结束时间
	
	System.out.println("插入"+a*b+"条数据，用时:"+(endTime-startTime)/1000+"s");
   
 }
}
