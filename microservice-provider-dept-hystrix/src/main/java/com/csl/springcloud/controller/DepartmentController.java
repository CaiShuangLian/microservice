package com.csl.springcloud.controller;

import com.csl.springcloud.entities.Department;
import com.csl.springcloud.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "department：部门")
@RequestMapping("/department")
@RestController
public class DepartmentController {

    /**
     * 新增员工
     */
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    @ApiOperation(value = "新增",notes = "新增部门信息")
    public Integer addDept(@RequestBody Department department){
        return departmentService.addDept(department);
    }

    /**
     * 更新信息
     * @param departmentId
     * @return
     */
    @ApiOperation(value = "更新",notes = "根据传入信息更新数据")
    @RequestMapping(value = "/update/{departmentId}",method = RequestMethod.PATCH)
    public Integer updateDeptById(@ApiParam("部门id") @PathVariable("departmentId")Long departmentId,@RequestBody Department department){
       department.setDepartmentId(departmentId);
        return departmentService.updateDeptById(department);
    }
}
