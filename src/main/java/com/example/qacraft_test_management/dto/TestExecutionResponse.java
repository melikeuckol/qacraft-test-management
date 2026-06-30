package com.example.qacraft_test_management.dto;

import com.example.qacraft_test_management.enums.ExecutionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class TestExecutionResponse {
    private Long id;
    private Long testCaseId;
    private String testCaseTitle;

    private String executor;
    private LocalDateTime executionDate;
    private ExecutionStatus status;
    private Long executionTimeInSeconds;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
