package com.lyj.repository;

import com.lyj.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {

}
