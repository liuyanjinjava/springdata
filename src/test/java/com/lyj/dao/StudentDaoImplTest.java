package com.lyj.dao;

import com.lyj.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {

    @Test
    public void query() {
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> students=studentDao.query();
        for (Student student:
             students) {
            System.out.println("id:"+student.getId()+", name:"+student.getName()+
                    ", age"+student.getAge());
        }
    }

    @Test
    public void testSave() {
        StudentDao studentDao=new StudentDaoImpl();
        Student student=new Student();
        student.setName("test");
        student.setAge(30);

        studentDao.save(student);
    }
}