package com.csl.springcloud.service;

import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.impl.EmployeeClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICE-EMPLOYEE",fallbackFactory = EmployeeClientServiceFallbackFactory.class)
@RequestMapping("/employee")
public interface EmployeeClientService {
    @RequestMapping(value = "/get/{firstName}",method = RequestMethod.GET)
    List<EmployeeVo> getEmployeeByFirstName(@PathVariable("firstName") String firstName);

    @RequestMapping(value = "/add",method =RequestMethod.PUT )
    Integer addEmployee();

    @RequestMapping(value = "/update/{employeeId}",method = RequestMethod.PATCH)
    Integer updateEmployeeById(@PathVariable("employeeId")Long employeeId);

    @RequestMapping(value = "/delete/{employeeId}",method = RequestMethod.DELETE)
    Integer deleteEmployById(@PathVariable("employeeId")Long employeeId);
}
