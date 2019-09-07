package com.springjdbcsept.springjdbcsept.controller;

import com.springjdbcsept.springjdbcsept.dao.EmployeeDao;
import com.springjdbcsept.springjdbcsept.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/getdata")
    public List<Employee> fetchData(){
        List<Employee> list=employeeDao.getData();
        return list;
    }

    @PostMapping(value="/savedata")
    public String insertEmployee(@RequestBody Employee employee){
        String str=employeeDao.insertData(employee);
        return str;
    }
}
