package com.nr.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("FROM Employee WHERE hireDate BETWEEN :sd AND :ed")
	List<Employee> findAllHiredBetween(@Param("sd") LocalDate s, @Param("ed") LocalDate e);
	
	
	@Query("FROM Employee WHERE hireDate < :dt")
	List<Employee> findAllHiredBefore(@Param("dt") LocalDate d);
}
