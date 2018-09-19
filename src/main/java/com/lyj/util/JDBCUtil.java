package com.lyj.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 描述:JDBC 工具类；
 *
 * @author lyj
 * @create 2018-09-19 0:04
 */

public class JDBCUtil {
    /**
     * 获取Connection
     * @return 所获取到的jdbc的connection
     */
  public static Connection getConnection() throws Exception{
      /**
       * 不建议大家把配置硬编码到代码中；
       *
       * 最佳实践：配置性的建议写到配置文件中；
       */
//       String url="jdbc:mysql:///spring_data";
//       String user="root";
//       String password="root";
//       String driverClass="com.mysql.jdbc.Driver";
       InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
       Properties properties=new Properties();
       properties.load(inputStream);
       String url=properties.getProperty("jdbc.url");
       String user=properties.getProperty("jdbc.user");
       String password=properties.getProperty("jdbc.password");
       String driverClass=properties.getProperty("jdbc.driverClass");
      Class.forName(driverClass);
      Connection connection=DriverManager.getConnection(url,user,password);
      return connection;
  }


    /**
     * 释放DB相关的资源；
     * @param resultSet
     * @param statement
     * @param connection
     */
   public static void release(ResultSet resultSet, Statement statement,Connection connection){
      if(resultSet!=null){
           try {
               resultSet.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       if(statement!=null){
           try {
               statement.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       if(connection!=null){
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

   }

}
