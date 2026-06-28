package com.example.qacraft_test_management.dto;

import com.example.qacraft_test_management.enums.Priority;
import com.example.qacraft_test_management.enums.TestCaseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCaseRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @Size(max = 1000, message = "Preconditions cannot exceed 1000 characters")
    private String preconditions;

    @NotBlank(message = "Steps are required")
    @Size(max = 2000, message = "Steps cannot exceed 2000 characters")
    private String steps;

    @NotBlank(message = "Expected result is required")
    @Size(max = 1000, message = "Expected result cannot exceed 1000 characters")
    private String expectedResult;
    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Status is required")
    private TestCaseStatus status;
}
