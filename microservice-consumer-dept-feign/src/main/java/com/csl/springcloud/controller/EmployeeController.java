package com.csl.springcloud.controller;

import com.csl.springcloud.Vo.EmployeeVo;
import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "consumer:Employee")
@RestController
@RequestMapping("/consumer/employee")
public class EmployeeController {
    @Autowired
    private EmployeeClientService employeeClientService=null;

    @ApiOperation(value = "查询",notes = "模糊查询")
    @GetMapping(value = "/get/{firstName}")
    public List<EmployeeVo>  getEmployeeByFirstName(@PathVariable("firstName")String firstName ){
       List<EmployeeVo> employeeVos=employeeClientService.getEmployeeByFirstName(firstName);
        return employeeVos;
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public Integer addEmployee(){
        Integer row=employeeClientService.addEmployee();
        return row;
    }

    @ApiOperation(value = "更新")
    @PostMapping(value = "/update/{employeeId}")
    public Integer updateEmployeeById(@PathVariable("employeeId")Long employeeId,@RequestBody Employee employee){
        employee.setEmployeeId(employeeId);
        Integer row=employeeClientService.updateEmployeeById(employee.getEmployeeId());
        return row;
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{employeeId}",method = RequestMethod.DELETE)
    public Integer deleteEmployeeById(@PathVariable("employeeId")Long employeeId){
        Integer row=employeeClientService.deleteEmployById(employeeId);
        return row;
    }
}
