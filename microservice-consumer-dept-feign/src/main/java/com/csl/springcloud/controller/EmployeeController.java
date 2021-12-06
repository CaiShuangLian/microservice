package com.csl.springcloud.controller;

import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class EmployeeController {
    @Autowired
    private EmployeeClientService employeeClientService=null;

    @GetMapping(value = "/employee/get/{firstName}")
    public Employee  getEmployeeByFirstName(@PathVariable("firstName")String firstName ){
        Employee employee= employeeClientService.getEmployeeByFirstName(firstName);
        return employee;
    }

    @RequestMapping(value = "/employee/add")
    public Integer addEmployee(){
        Integer row=employeeClientService.addEmployee();
        return row;
    }

    @RequestMapping(value = "/employee/update/{employeeId}")
    public Integer updateEmployeeById(@PathVariable("employeeId")Long employeeId){
        Integer row=employeeClientService.updateEmployeeById(employeeId);
        return row;
    }

    @RequestMapping(value = "/employee/delete/{employeeId}")
    public Integer deleteEmployeeById(@PathVariable("employeeId")Long employeeId){
        Integer row=employeeClientService.deleteEmployById(employeeId);
        return row;
    }
}
