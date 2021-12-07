package com.csl.springcloud.dao;

import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeDao {
     //根据firstName查询员工信息
     List<EmployeeVo> getEmployeeByFirstName(@Param("firstName") String firstName);
     //addEmployee
     Integer addEmployee(Employee employee);

     Integer deleteEmployById(@Param("employeeId") Long employeeId);

     Integer updateEmployeeById(Employee employee);

    List<EmployeeVo> getEmployeeByDeptCode(String deptCode);
}
