package com.csl.springcloud.Vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("员工信息")
@Data
public class EmployeeVo {
    private String firstName;
    private String lastName;
    private String sex;
    private String phoneNum;
    private String email;
    private String departmentCode;
    private String departmentName;
    private String detailAddress;
}
