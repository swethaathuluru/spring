package com.example.services;

import java.util.List;

import com.example.beans.Employee;
import com.example.exception.IdNotFoundException;



public interface IEmployeeService {
	public Employee addEmployee(Employee employee) throws IdNotFoundException;
	 
	 public List<Employee> displayEmployee() ;
	 
	public Employee update(Employee employee,int id) throws IdNotFoundException ;
	
	public Boolean delete(int id) throws IdNotFoundException ;
	
	public  Employee search(int id) throws IdNotFoundException ;
	
}
