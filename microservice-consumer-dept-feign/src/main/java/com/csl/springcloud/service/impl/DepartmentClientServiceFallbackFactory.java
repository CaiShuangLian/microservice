package com.csl.springcloud.service.impl;

import com.csl.springcloud.entities.Department;
import com.csl.springcloud.service.DepartmentClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DepartmentClientServiceFallbackFactory implements FallbackFactory<DepartmentClientService> {
    @Override
    public DepartmentClientService create(Throwable cause) {
        return new DepartmentClientService() {
            @Override
            public Integer addDept(Department department) {
                return -1;
            }

            @Override
            public Integer updateDeptById(Department department) {
                return -1;
            }
        };
    }
}
