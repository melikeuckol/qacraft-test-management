package com.example.qacraft_test_management.dto;

import com.example.qacraft_test_management.enums.BugSeverity;
import com.example.qacraft_test_management.enums.BugStatus;
import com.example.qacraft_test_management.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BugRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 150)
    private String title;

    @Size(max = 2000)
    private String description;

    @NotNull(message = "Severity is required")
    private BugSeverity severity;

    @NotNull(message = "Priority is required")
    private Priority priority;

    private BugStatus status;

    private String reporter;
    private String assignee;
    private String environment;
    private String browser;
    private String operatingSystem;

    @NotBlank(message = "Steps to reproduce are required")
    @Size(max = 2000)
    private String stepsToReproduce;

    @NotBlank(message = "Expected result is required")
    @Size(max = 1000)
    private String expectedResult;

    @NotBlank(message = "Actual result is required")
    @Size(max = 1000)
    private String actualResult;

    @NotNull(message = "Test execution id is required")
    private Long testExecutionId;
}
