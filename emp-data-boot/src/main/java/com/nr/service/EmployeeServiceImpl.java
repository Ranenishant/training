package com.nr.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nr.entity.Employee;
import com.nr.repo.EmployeeRepository;
import com.nr.util.EmployeeNotFoundException;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	@Override
	public void save(Employee e) {
		repository.save(e);
	}

	@Override
	public Employee fetch(int id) throws EmployeeNotFoundException {
		return repository.findById(id).orElseThrow(()->new EmployeeNotFoundException("No employee found for id: "+id));
	}

	@Override
	public List<Employee> list() {
		return repository.findAll();
	}

	@Override
	public void remove(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Employee> findEmployeeHiredBetweenDate(LocalDate s, LocalDate e) throws EmployeeNotFoundException {
		List<Employee> e1= repository.findAllHiredBetween(s, e);
		for(Employee emp: e1) {
			if(e1.isEmpty()) {
				throw new EmployeeNotFoundException("No employee found between the dates "+s+" and "+e);
			}
			else{
				e1.add(emp);
			}
		}
		return e1;
	}

	@Override
	public List<Employee> findEmployeeHiredBeforeDate(LocalDate d) {
		return repository.findAllHiredBefore(d);
	}

}
