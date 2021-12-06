package com.csl.springcloud.service;

import com.csl.springcloud.dao.EmployeeDao;
import com.csl.springcloud.entities.Employee;

public interface EmployeeService {
    //    根据firstName查询员工信息
    public Employee getEmployeeByFirstName(String firstName);

    public Integer addEmployee(Employee employee);

    public Integer deleteEmployById(Long employeeId);

    Integer updateEmployeeById(Employee employee);
}
