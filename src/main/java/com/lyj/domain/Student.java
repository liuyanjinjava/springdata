package com.lyj.domain;


import lombok.Data;

/**
 * 描述:
 *
 * @author lyj
 * @create 2018-09-19 13:31
 */
@Data
public class Student {
    /**
     *  主键字段
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
}
