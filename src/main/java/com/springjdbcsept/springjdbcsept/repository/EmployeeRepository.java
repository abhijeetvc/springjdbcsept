package com.springjdbcsept.springjdbcsept.repository;

import com.springjdbcsept.springjdbcsept.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getData();

    String insertData(Employee employee);

}
