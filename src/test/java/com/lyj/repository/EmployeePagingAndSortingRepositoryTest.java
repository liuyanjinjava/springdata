package com.lyj.repository;

import com.lyj.domain.Employee;
import com.lyj.service.EmployeeService;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;

import java.util.ArrayList;
import java.util.List;

public class EmployeePagingAndSortingRepositoryTest {


    private ApplicationContext ctx=null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository=null;

    @Before
    public void setUp(){
        ctx =new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
   public void testPage(){
        //page:index 是0开始的，不是从1开始的；
        Pageable pageable = new PageRequest(1,9);
       Page<Employee> page= employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询的总页数"+page.getTotalPages());
        System.out.println("查询的总记录数"+page.getTotalElements());
        System.out.println("查询的当前第几页"+(page.getNumber()+1));
        System.out.println("查询的当前页面的集合"+page.getContent());
        System.out.println("查询的当前页面的记录数"+page.getNumberOfElements());

   }
   @Test
    public void testPageAndSort(){
        Sort.Order order= new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=new Sort(order);
       Pageable pageable = new PageRequest(0,5,sort);
       Page<Employee> page= employeePagingAndSortingRepository.findAll(pageable);

       System.out.println("查询的总页数"+page.getTotalPages());
       System.out.println("查询的总记录数"+page.getTotalElements());
       System.out.println("查询的当前第几页"+(page.getNumber()+1));
       System.out.println("查询的当前页面的集合"+page.getContent());
       System.out.println("查询的当前页面的记录数"+page.getNumberOfElements());

   }


}