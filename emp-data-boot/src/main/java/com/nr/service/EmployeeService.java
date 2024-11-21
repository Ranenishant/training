package com.nr.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.nr.entity.Employee;
import com.nr.util.EmployeeNotFoundException;

public interface EmployeeService {

	
	public void save(Employee e);
	
	public Employee fetch(int id) throws EmployeeNotFoundException;
	
	public List<Employee> list();
	
	public void remove(int id);
	
	List<Employee> findEmployeeHiredBetweenDate(@Param("sd") LocalDate s, @Param("ed") LocalDate e) throws EmployeeNotFoundException;

	List<Employee> findEmployeeHiredBeforeDate(@Param("dt") LocalDate d);

	
}
