package com.lyj.repository;

import com.lyj.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class EmployeeJpaRepositoryTest {


    private ApplicationContext ctx=null;
    private EmployeeJpaRepository employeeJpaRepository=null;

    @Before
    public void setUp(){
        ctx =new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        Optional<Employee> employee = employeeJpaRepository.findById(99);
        System.out.println("employee: "+employee);

//  true      System.out.println("employee(10):"+employeeJpaRepository.exists(10));
        //有很多涉及到java8的新特性，要看懂源码必须好好研究java基础；
//  false      System.out.println("employee(10):"+employeeJpaRepository.exists(102));



    }


}