package com.example.qacraft_test_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardResponse {
    private Long totalTestCases;

    private Long totalExecutions;

    private Long passedExecutions;

    private Long failedExecutions;

    private Long blockedExecutions;

    private Double passRate;

    private Double failRate;

    private Long openBugs;

    private Long criticalBugs;

    private Double averageExecutionTime;
}
