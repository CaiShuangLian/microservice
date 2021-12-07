package com.csl.springcloud.service;

import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.entities.Employee;

import java.util.List;

public interface EmployeeService {
    //    根据firstName查询员工信息
    List<EmployeeVo> getEmployeeByFirstName(String firstName);

    Integer addEmployee(Employee employee);

    Integer deleteEmployById(Long employeeId);

    Integer updateEmployeeById(Employee employee);

    List<EmployeeVo> getEmployeeByDeptCode(String deptCode);
}
