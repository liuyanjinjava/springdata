package com.lyj.repository;

import com.lyj.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {

}
