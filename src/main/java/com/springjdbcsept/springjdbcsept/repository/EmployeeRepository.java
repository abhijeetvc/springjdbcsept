package com.springjdbcsept.springjdbcsept.repository;

import com.springjdbcsept.springjdbcsept.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getData();

    String insertData(Employee employee);

    List<Map<String,Object>> getCombineData();

}
