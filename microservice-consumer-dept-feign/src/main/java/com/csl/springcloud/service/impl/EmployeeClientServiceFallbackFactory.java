package com.csl.springcloud.service.impl;

import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeClientServiceFallbackFactory implements FallbackFactory<EmployeeClientService> {
    @Override
    public EmployeeClientService create(Throwable cause) {
        return new EmployeeClientService(){

            @Override
            public Employee getEmployeeByFirstName(String firstName) {
                return new Employee().setFirstName(firstName).setEmployeeNum("无信息");
            }

            //-1表示操作失败
            @Override
            public Integer addEmployee() {
                return -1;
            }

            @Override
            public Integer updateEmployeeById(Long employeeId) {
                return -1;
            }

            @Override
            public Integer deleteEmployById(Long employeeId) {
                return -1;
            }

        };
    }
}
