package com.example.qacraft_test_management.mapper;

import com.example.qacraft_test_management.dto.TestExecutionRequest;
import com.example.qacraft_test_management.dto.TestExecutionResponse;
import com.example.qacraft_test_management.entity.TestExecution;
import org.springframework.stereotype.Component;

@Component
public class TestExecutionMapper {
    public TestExecution toEntity(TestExecutionRequest request) {
        TestExecution execution = new TestExecution();

        execution.setExecutor(request.getExecutor());
        execution.setStatus(request.getStatus());
        execution.setExecutionTimeInSeconds(request.getExecutionTimeInSeconds());
        execution.setNotes(request.getNotes());

        return execution;
    }

    public void updateEntity(TestExecution execution, TestExecutionRequest request) {
        execution.setExecutor(request.getExecutor());
        execution.setStatus(request.getStatus());
        execution.setExecutionTimeInSeconds(request.getExecutionTimeInSeconds());
        execution.setNotes(request.getNotes());
    }

    public TestExecutionResponse toResponse(TestExecution execution) {
        TestExecutionResponse response = new TestExecutionResponse();

        response.setId(execution.getId());

        if (execution.getTestCase() != null) {
            response.setTestCaseId(execution.getTestCase().getId());
            response.setTestCaseTitle(execution.getTestCase().getTitle());
        }

        response.setExecutor(execution.getExecutor());
        response.setExecutionDate(execution.getExecutionDate());
        response.setStatus(execution.getStatus());
        response.setExecutionTimeInSeconds(execution.getExecutionTimeInSeconds());
        response.setNotes(execution.getNotes());
        response.setCreatedAt(execution.getCreatedAt());
        response.setUpdatedAt(execution.getUpdatedAt());

        return response;
    }
}
