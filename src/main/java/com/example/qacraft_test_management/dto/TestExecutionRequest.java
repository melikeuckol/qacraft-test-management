package com.example.qacraft_test_management.dto;

import com.example.qacraft_test_management.enums.ExecutionStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestExecutionRequest {
    @NotNull(message = "Test case id is required")
    private Long testCaseId;

    private String executor;

    @NotNull(message = "Execution status is required")
    private ExecutionStatus status;

    private Long executionTimeInSeconds;

    @Size(max = 1500, message = "Notes cannot exceed 1500 characters")
    private String notes;
}
