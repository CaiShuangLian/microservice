package com.csl.springcloud.service.impl;

import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeClientServiceFallbackFactory implements FallbackFactory<EmployeeClientService> {
    @Override
    public EmployeeClientService create(Throwable cause) {
        return new EmployeeClientService(){

            @Override
            public List<EmployeeVo> getEmployeeByFirstName(String firstName) {
                return null;
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
