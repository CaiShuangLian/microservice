package com.csl.springcloud.service.impl;

import com.csl.springcloud.dao.DepartmentDao;
import com.csl.springcloud.entities.Department;
import com.csl.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Integer addDept(Department department) {
        return departmentDao.addDept(department);
    }

    @Override
    public Integer updateDeptById(Department department) {
        return departmentDao.updateDeptById(department);
    }
}
