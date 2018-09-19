package com.lyj.service;

import com.lyj.domain.Employee;
import com.lyj.repository.EmployeeCrudRepository;
import com.lyj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 描述:
 *
 * @author lyj
 * @create 2018-09-20 0:49
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id,Integer age){
        employeeRepository.update(id,age);
    }

    @Transactional
    public void saveAll(List<Employee> employees){
        employeeCrudRepository.saveAll(employees);
    }
}

