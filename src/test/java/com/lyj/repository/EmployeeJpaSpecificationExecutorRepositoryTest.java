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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.swing.text.html.HTMLDocument;

import static org.junit.Assert.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx=null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository=null;

    @Before
    public void setUp(){
        ctx =new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }
    @Test
    public void testQuery(){
        Sort.Order order= new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=new Sort(order);
        Pageable pageable = new PageRequest(0,5,sort);
        Specification<Employee> specification=new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //root(employee (age))
                Path path=root.get("age");

                return criteriaBuilder.gt(path,50);
            }
        };
        Page<Employee> page= employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);

        System.out.println("查询的总页数"+page.getTotalPages());
        System.out.println("查询的总记录数"+page.getTotalElements());
        System.out.println("查询的当前第几页"+(page.getNumber()+1));
        System.out.println("查询的当前页面的集合"+page.getContent());
        System.out.println("查询的当前页面的记录数"+page.getNumberOfElements());
    }
}