package com.springjdbcsept.springjdbcsept.dao;

import com.springjdbcsept.springjdbcsept.model.Employee;
import com.springjdbcsept.springjdbcsept.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<String, Object>> getCombineData() {

        String sql="select a.name,a.age,a.city,b.name as deptName from employee a,department b where a.deptId=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
