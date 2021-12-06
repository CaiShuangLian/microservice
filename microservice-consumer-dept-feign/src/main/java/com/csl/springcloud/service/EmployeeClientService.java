package com.csl.springcloud.service;

import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.impl.EmployeeClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "MICROSERVICE-DEPT",fallbackFactory = EmployeeClientServiceFallbackFactory.class)
public interface EmployeeClientService {
    @RequestMapping(value = "/employee/get/{firstName}",method = RequestMethod.GET)
    public Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName);

    @RequestMapping(value = "/employee/add")
    public Integer addEmployee();

    @RequestMapping(value = "/employee/update/{employeeId}")
    Integer updateEmployeeById(@PathVariable("employeeId")Long employeeId);

    @RequestMapping(value = "/employee/delete/{employeeId}")
    Integer deleteEmployById(@PathVariable("employeeId")Long employeeId);
}
