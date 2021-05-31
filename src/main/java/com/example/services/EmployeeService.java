package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Employee;
import com.example.dao.EmployeeDao;
import com.example.exception.IdNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao rdo;

	public Employee addEmployee(Employee employee) throws IdNotFoundException {

		if (!rdo.findById(employee.getId()).isPresent())

			return rdo.save(employee);
		else
			throw new IdNotFoundException("id already present");

	}

	public List<Employee> displayEmployee() {

		return rdo.findAll();

	}

	public Employee update(Employee employee, int id) throws IdNotFoundException {
		if (rdo.findById(id).isPresent()) {
			return rdo.saveAndFlush(employee);
		} else
			throw new IdNotFoundException("id not present");
	}

	public Boolean delete(int id) throws IdNotFoundException {
		if (rdo.findById(id).isPresent()) {
			rdo.deleteById(id);
			return true;
		} else
			throw new IdNotFoundException("id not present");

	}

	public Employee search(int id) throws IdNotFoundException {
		if (rdo.findById(id).isPresent())
			return rdo.findById(id).get();

		else
			throw new IdNotFoundException("id not present");

	}

}
