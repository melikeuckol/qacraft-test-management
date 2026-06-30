package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.TestExecutionRequest;
import com.example.qacraft_test_management.dto.TestExecutionResponse;

import java.util.List;

public interface TestExecutionService {
    TestExecutionResponse createExecution(TestExecutionRequest request);

    List<TestExecutionResponse> getAllExecutions();

    TestExecutionResponse getExecutionById(Long id);

    TestExecutionResponse updateExecution(Long id, TestExecutionRequest request);

    void deleteExecution(Long id);

    List<TestExecutionResponse> getExecutionsByTestCaseId(Long testCaseId);
}
