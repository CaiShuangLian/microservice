package com.csl.springcloud.controller;


import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "employee:员工")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工
     *
     * @param firstName
     * @return
     */
    @ApiOperation(value = "查询", notes = "根据firstName或者lastName模糊查询")
    @RequestMapping(value = "/employee/get/{firstName}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public List<EmployeeVo> getEmployeeByFirstName(@ApiParam("模糊查询key") @PathVariable("firstName") String firstName) {
        List<EmployeeVo> employees = employeeService.getEmployeeByFirstName(firstName);
        System.out.println("查询条数：" + employees.size());
        if (employees.isEmpty()) {
            throw new RuntimeException("该ID：" + firstName + "：没有对应的信息");
        }
        return employees;
    }

    /**
     * 新增员工
     *
     * @return
     */
    @ApiOperation(value = "新增", notes = "新增一天员工信息")
    @PostMapping(value = "/employee/add")
    public Integer addEmployee(@RequestBody Employee employee) {
        Integer row = employeeService.addEmployee(employee);
        if (row < 1) {
            throw new RuntimeException("插入失败");
        }

        return row;
    }

    /**
     * 删除员工
     *
     * @param employeeId
     * @return
     */
    @ApiOperation(value = "删除", notes = "根据id删除员工信息")
    @RequestMapping(value = "/employee/delete/{employeeId}", method = RequestMethod.DELETE)
    public Integer deleteEmployById(@ApiParam("员工id") @PathVariable("employeeId") Long employeeId) {
        Integer row = employeeService.deleteEmployById(employeeId);
        if (row < 1) {
            throw new RuntimeException("删除失败");
        }

        return row;
    }

    /**
     * 更新员工
     *
     * @param employeeId
     * @return
     */
    @ApiOperation(value = "更新员工", notes = "根据传入信息选择更新")
    @RequestMapping(value = "employee/update/{employeeId}", method = RequestMethod.POST)
    public Integer updateEmployeeById(@ApiParam("员工id") @PathVariable("employeeId") Long employeeId,@RequestBody Employee employee) {
        employee.setEmployeeId(employeeId);
        Integer row = employeeService.updateEmployeeById(employee);
        if (row < 1) {
            throw new RuntimeException("修改失败");
        }
        return row;
    }

    /**
     * 查询员工
     *
     * @param deptCode
     * @return
     */
    @ApiOperation(value = "查询", notes = "根据deptCode精确查询")
    @RequestMapping(value = "/employee/get/v1/{deptCode}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public List<EmployeeVo> getEmployeeByDeptCode(@ApiParam("deptCode精确查询") @PathVariable("deptCode") String deptCode) {
        List<EmployeeVo> employees = employeeService.getEmployeeByDeptCode(deptCode);
        System.out.println("查询条数：" + employees.size());
        if (employees.isEmpty()) {
            throw new RuntimeException("该ID：" + deptCode + "：没有对应的信息");
        }
        return employees;
    }


    public List<EmployeeVo> processHystrix_Get(@PathVariable("firstName") String firstName) {
       return null;
    }

}
