package com.lyj.dao;

import com.lyj.domain.Student;

import java.util.List;

/**
 * 描述:
 * studentDao访问接口
 *
 * @author lyj
 * @create 2018-09-19 13:46
 */
public interface StudentDao {
    /**
     * 查询所有学生
     * @return 所有学生
     */
    public List<Student> query();

    /**
     * 添加一个学生
     * @param student 待添加的学生
     */
    public void save(Student student);
}
