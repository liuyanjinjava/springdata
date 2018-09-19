package com.lyj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:
 *
 * @author lyj
 * @create 2018-09-19 19:59
 */
public class SpringDataTest {
    private ApplicationContext ctx=null;

    @Before
    public void setUp(){
        ctx =new ClassPathXmlApplicationContext("beans-new.xml");
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }
    @Test
    public void testEntityManagerFactory(){

    }
}
