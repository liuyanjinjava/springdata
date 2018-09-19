package com.lyj.dao;

import com.lyj.domain.Student;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author lyj
 * @create 2018-09-19 16:42
 */
@Data
public class StudentDaoSpringJdbcImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> query() {
         List<Student> students=new ArrayList<>();
        String sql="select id , name ,age from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                Student student=new Student();
                student=new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql="insert into student (name, age) values (?,?);";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }
}
