package com.csl.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;


@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Employee {
    private Long employeeId;
    private String employeeNum;
    private String firstName;
    private String lastName;
    private String sex;
    private String phoneNum;
    private String email;
    private Date hireDate;
    private Long departmentId;
    private String statusCode;

//    private Department department;
//    private Job job;
//    private Location location;
//
////    detail_address
//    private String detailAddress;


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeNum='" + employeeNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                ", departmentId=" + departmentId +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
