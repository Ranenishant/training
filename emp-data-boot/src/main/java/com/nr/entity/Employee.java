package com.nr.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="emp2")
public class Employee {
	
	@Id
	@Column(name="emp_no")
	private int empNo;
	
	@Size(max = 30, message = "Employee name cannot exceed 30 characters")
	@NotBlank(message = "Employee name cannot be blank")
	@Column(name="ename",length=30)
	private String empName;
	
	@Size(max = 20, message = "Job title should not exceed 20 characters")
	@Column(length=20)
	private String job;
	
	@NotNull(message = "Salary cannot bu null")
	@Min(value = 0, message = "Salary must be greater than or equal to 0")
	private double salary;
	
	@NotNull(message = "Hire date cannot be null")
	@Past(message = "Hire date must be in the past")
	@Column(name="hire_date")
	private LocalDate hireDate;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public int getEmpNo() {
		return empNo;
	}




	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public String getJob() {
		return job;
	}




	public void setJob(String job) {
		this.job = job;
	}




	public double getSalary() {
		return salary;
	}




	public void setSalary(double salary) {
		this.salary = salary;
	}




	public LocalDate getHireDate() {
		return hireDate;
	}




	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}




	public Employee(int empNo, String empName, String job, double salary, LocalDate hireDate) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	
	
}
