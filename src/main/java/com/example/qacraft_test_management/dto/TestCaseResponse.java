package com.example.qacraft_test_management.dto;

import com.example.qacraft_test_management.enums.Priority;
import com.example.qacraft_test_management.enums.TestCaseStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class TestCaseResponse {
    private Long id;
    private String title;
    private String description;
    private String preconditions;
    private String steps;
    private String expectedResult;
    private Priority priority;
    private TestCaseStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
