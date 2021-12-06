package com.csl.springcloud.controller;


import com.csl.springcloud.entities.Employee;
import com.csl.springcloud.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService=null;

    @RequestMapping(value = "/employee/get/{firstName}",method= RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName){
        Employee employee=employeeService.getEmployeeByFirstName(firstName);
        if(null==employee){
            throw new RuntimeException("该ID："+firstName+"：没有对应的信息");
        }
        System.out.println(employee.toString());
        return employee;
    }

    @RequestMapping(value = "/employee/add")
    public Integer addEmployee(){
        Employee employee=new Employee().setEmployeeNum("en4")
                .setFirstName("admin4")
                .setLastName("admin4")
                .setSex("女")
                .setPhoneNum("12345678910")
                .setEmail("2243157861@qq.com")
                .setDepartmentId(1L)
                .setStatusCode("在职");
        Integer row=employeeService.addEmployee(employee);
        if(row<1){
            throw new RuntimeException("插入失败");
        }

        return row;
    }

    @RequestMapping(value = "/employee/delete/{employeeId}")
    public Integer deleteEmployById(@PathVariable("employeeId")Long employeeId){
        Integer row=employeeService.deleteEmployById(employeeId);
        if(row<1){
            throw new RuntimeException("删除失败");
        }

        return row;
    }

    @RequestMapping(value = "employee/update/{employeeId}")
    public Integer updateEmployeeById(@PathVariable("employeeId")Long employeeId){
        Employee employee=new Employee().setEmployeeId(employeeId)
                .setEmployeeNum("en4")
                .setFirstName("admin4")
                .setLastName("admin4")
                .setSex("女")
                .setPhoneNum("12345678910")
                .setEmail("2243157861@qq.com")
                .setDepartmentId(1L)
                .setStatusCode("在职");
        Integer row =employeeService.updateEmployeeById(employee);
        if(row<1){
            throw new RuntimeException("修改失败");
        }
        return row;
    }


    public Employee processHystrix_Get(@PathVariable("firstName") String firstName)
    {
        return new Employee().setFirstName(firstName).setEmployeeNum("异常");
    }

}
