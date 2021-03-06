package com.lyj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 描述:
 *
 * @author lyj
 * @create 2018-09-19 15:21
 */
public class DataSourceTest {
    private ApplicationContext ctx=null;

    @Before
    public void setUp(){
      ctx =new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }
    @After
    public void tearDown(){
      ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource(){
        System.out.println("testDataSource");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }
    @Test
    public void testJDBCTemplate(){
        System.out.println("testJDBCTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
    }

}
