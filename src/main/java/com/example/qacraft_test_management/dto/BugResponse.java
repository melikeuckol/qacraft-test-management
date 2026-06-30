package com.example.qacraft_test_management.dto;

import com.example.qacraft_test_management.enums.BugSeverity;
import com.example.qacraft_test_management.enums.BugStatus;
import com.example.qacraft_test_management.enums.ExecutionStatus;
import com.example.qacraft_test_management.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BugResponse {
    private Long id;
    private String title;
    private String description;
    private BugSeverity severity;
    private Priority priority;
    private BugStatus status;

    private String reporter;
    private String assignee;
    private String environment;
    private String browser;
    private String operatingSystem;

    private String stepsToReproduce;
    private String expectedResult;
    private String actualResult;

    private Long testExecutionId;
    private Long testCaseId;
    private String testCaseTitle;
    private ExecutionStatus executionStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
