package com.csl.springcloud.service.impl;

import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.dao.EmployeeDao;
import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpolyeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<EmployeeVo> getEmployeeByFirstName(String firstName) {
        return employeeDao.getEmployeeByFirstName(firstName);
    }

    @Override
    public Integer addEmployee(Employee employee) {

        return employeeDao.addEmployee(employee);
    }

    @Override
    public Integer deleteEmployById(Long employeeId) {

        return employeeDao.deleteEmployById(employeeId);
    }

    @Override
    public Integer updateEmployeeById(Employee employee) {

        return employeeDao.updateEmployeeById(employee);
    }

    @Override
    public List<EmployeeVo> getEmployeeByDeptCode(String deptCode) {
        return employeeDao.getEmployeeByDeptCode(deptCode);
    }
}
