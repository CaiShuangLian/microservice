package com.csl.springcloud.service;


import com.csl.springcloud.entities.Department;
import com.csl.springcloud.service.impl.DepartmentClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "MICROSERVICE-DEPT",fallbackFactory = DepartmentClientServiceFallbackFactory.class)
public interface DepartmentClientService {

    @RequestMapping(value = "/department/add",method = RequestMethod.PUT)
    Integer addDept(Department department);

    @RequestMapping(value = "/department/update/{departmentId}",method = RequestMethod.PATCH)
    Integer updateDeptById(Department department);
}
