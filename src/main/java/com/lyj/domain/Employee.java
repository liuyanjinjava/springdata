package com.lyj.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 描述:
 * 雇员 先开发实体类===》自动生成数据表；
 * @author lyj
 * @create 2018-09-19 20:02
 */
@Data
@Entity
@Table(name="test_employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false)
    private Integer age;

}
