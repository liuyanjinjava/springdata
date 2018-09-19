package com.lyj.dao;

import com.lyj.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDaoSpringJdbcImplTest {
    private ApplicationContext ctx=null;
    private StudentDao studentDao=null;

    @Before
    public void setUp(){
        ctx =new ClassPathXmlApplicationContext("beans.xml");
        studentDao=(StudentDao)ctx.getBean("studentDao");
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void query() {
        List<Student> students=studentDao.query();
        for (Student student:
             students) {
            System.out.println("id:"+student.getId()+", name:"+student.getName()+
                    ", age"+student.getAge());
        }
    }

    @Test
    public void testSave() {
        Student student=new Student();
        student.setName("test-springjdbc");
        student.setAge(40);

        studentDao.save(student);
    }
}