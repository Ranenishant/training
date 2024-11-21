package com.nr.rest;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.entity.Employee;
import com.nr.service.EmployeeService;
import com.nr.util.EmployeeNotFoundException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/fetch/{id}", produces = "application/json")
	public Employee getEmployee(@PathVariable int id) {
		try {
			return service.fetch(id);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@PostMapping(value="/save", consumes="application/json")
	public String saveEmployee(@RequestBody Employee e) {
		service.save(e);
		return "Employee details saved successfully";
	}
	
	@GetMapping(value="/list", produces="application/json")
	public List<Employee> getListOfEmployee(){
//		List<Employee> employees=service.list();
		return service.list();
	}
	
	@DeleteMapping(value = "/delete/{id}" )
	public void deleteEmployeeById(@PathVariable int id) {
		 service.remove(id);
		 System.out.println("Employee Deleted successfully.");
	}
	
	@GetMapping(value="/listbefore", produces="application/json")
	public List<Employee> getEmployeeBeforeHireDate(@PathVariable LocalDate d){
		List<Employee> employees=service.list();
		employees= service.findEmployeeHiredBeforeDate(d);
		return employees;
	}
	
	@GetMapping(value="/listbetween", produces="application/json")
	public List<Employee> getEmployeeBetweenHireDate(@PathVariable LocalDate s,@PathVariable LocalDate e){
		List<Employee> employees1=service.list();
		try {
			employees1= service.findEmployeeHiredBetweenDate(s,e);
		} catch (EmployeeNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employees1;
	}
	
}
