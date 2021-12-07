package com.csl.springcloud.dao;

import com.csl.springcloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentDao {
    //新增数据,返回影响行数
    Integer addDept(Department department);

    //根据id修改数据，返回影响行数
    Integer updateDeptById(Department department);
}
