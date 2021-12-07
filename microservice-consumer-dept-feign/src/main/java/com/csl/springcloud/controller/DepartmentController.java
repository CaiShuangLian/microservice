package com.csl.springcloud.controller;

import com.csl.springcloud.entities.Department;
import com.csl.springcloud.service.DepartmentClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "consumer:Department")
@RestController
@RequestMapping("/consumer/department")
public class DepartmentController {

    /**
     * 新增员工
     */
    @Autowired
    private DepartmentClientService departmentClientService;

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    @ApiOperation(value = "新增",notes = "新增部门信息")
    public Integer addDept(){
        Department department=new Department().setDepartmentCode("dc3")
                .setDepartmentName("财务部")
                .setLocationId(2L)
                .setManagerId(2L);

        return departmentClientService.addDept(department);
    }

    /**
     * 更新信息
     * @param departmentId
     * @return
     */
    @ApiOperation(value = "更新",notes = "根据传入信息更新数据")
    @RequestMapping(value = "/update/{departmentId}",method = RequestMethod.PATCH)
    public Integer updateDeptById(@ApiParam("部门id") @PathVariable("departmentId")Long departmentId){
        Department department=new Department()
                .setDepartmentId(departmentId)
                .setDepartmentCode("dc3")
                .setDepartmentName("财务部")
                .setLocationId(2L)
                .setManagerId(2L);

        return departmentClientService.updateDeptById(department);
    }
}
