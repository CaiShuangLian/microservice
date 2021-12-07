package com.csl.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Department {
    private Long departmentId;   //主键
    private String departmentCode;
    private String departmentName;
    private Long managerId;
    private Long locationId;


    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", managerId=" + managerId +
                ", locationId='" + locationId + '\'' +
                '}';
    }
}
