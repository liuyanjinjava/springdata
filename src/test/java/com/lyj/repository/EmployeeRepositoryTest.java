package com.lyj.repository;

import com.lyj.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx=null;
    private EmployeeRepository employeeRepository=null;

    @Before
    public void setUp(){
        ctx =new ClassPathXmlApplicationContext("beans-new.xml");
       employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void findByName() {
        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@3cb8c8ce
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id :"+employee.getId()
                +",  name:"+employee.getName()
                +",  age:"+employee.getAge());
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {

        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }
    @Test
    public void findByNameEndingWithAndAgeLessThan() {

        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6",23);
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }

    @Test
    public void findByNameInOrAgeLessThan() {
        List<String> names= new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,22);
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }

    @Test
    public void findByNameInAndAgeLessThan() {
        List<String> names= new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,22);
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }
    @Test
    public void getEmployeeByMaxId() {

        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id :"+employee.getId()
                +",  name:"+employee.getName()
                +",  age:"+employee.getAge());

    }

    @Test
    public void queryParams1() {

        List<Employee> employees = employeeRepository.queryParams1("zhangsan",20);
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }

    @Test
    public void queryParams2() {

        List<Employee> employees = employeeRepository.queryParams2("zhangsan",20);
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }

    @Test
    public void queryLike1() {

        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }
    @Test
    public void queryLike2() {

        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }
    @Test
    public void queryLike3() {

        List<Employee> employees = employeeRepository.queryLike3("test1");
        for (Employee employee:
                employees) {
            System.out.println("id :"+employee.getId()
                    +",  name:"+employee.getName()
                    +",  age:"+employee.getAge());

        }

    }
    @Test
    public void getCount() {
        long count = employeeRepository.getCount();
        System.out.println("count :"+count);
    }

}