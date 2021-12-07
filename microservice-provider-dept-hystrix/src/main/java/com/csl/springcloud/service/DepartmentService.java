package com.csl.springcloud.service;

import com.csl.springcloud.entities.Department;

public interface DepartmentService {
    //新增部门
    Integer addDept(Department department);

    Integer updateDeptById(Department department);
}
