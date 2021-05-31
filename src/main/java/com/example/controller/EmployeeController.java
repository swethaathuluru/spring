package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Employee;
import com.example.exception.IdNotFoundException;
import com.example.services.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) throws IdNotFoundException {

		return new ResponseEntity<Employee>(service.addEmployee(e), HttpStatus.CREATED);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee e) throws IdNotFoundException {

		return new ResponseEntity<Employee>(service.update(e,id), HttpStatus.CREATED);
	}

	@GetMapping("/displayEmployee")
	public ResponseEntity<List<Employee>> displayEmployee() throws IdNotFoundException {

		return new ResponseEntity<List<Employee>>(service.displayEmployee(), HttpStatus.CREATED);
	}

	@GetMapping("/searchEmployee/{id}")
	public ResponseEntity<Employee> search(@PathVariable int id) throws IdNotFoundException {

		return new ResponseEntity<Employee>(service.search(id), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) throws IdNotFoundException {

		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.CREATED);
	}
	

}
