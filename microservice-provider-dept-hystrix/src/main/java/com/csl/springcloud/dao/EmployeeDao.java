package com.csl.springcloud.dao;

import com.csl.springcloud.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {
//    根据firstName查询员工信息
     Employee getEmployeeByFirstName(String firstName);
//addEmployee
     Integer addEmployee(Employee employee);

     Integer deleteEmployById(Long employeeId);

     Integer updateEmployeeById(Employee employee);
}
