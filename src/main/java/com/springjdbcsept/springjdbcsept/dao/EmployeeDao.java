package com.springjdbcsept.springjdbcsept.dao;

import com.springjdbcsept.springjdbcsept.model.Employee;
import com.springjdbcsept.springjdbcsept.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getData() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public String insertData(Employee employee) {

        String sql="insert into employee values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),
        employee.getName(),employee.getAge(),employee.getCity()});
        return "Data saved successfully";
    }
}
