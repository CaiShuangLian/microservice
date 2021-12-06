package com.csl.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Job {
    private Long jobId;
    private String jobCode;
    private String jobName;
    private Integer primaryFlag;
    private Integer enabledFlag;
    private Long employeeId;

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobCode='" + jobCode + '\'' +
                ", jobName='" + jobName + '\'' +
                ", primaryFlag=" + primaryFlag +
                ", enabledFlag=" + enabledFlag +
                ", employeeId=" + employeeId +
                '}';
    }
}
