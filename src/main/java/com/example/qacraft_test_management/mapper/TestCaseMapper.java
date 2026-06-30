package com.example.qacraft_test_management.mapper;

import com.example.qacraft_test_management.dto.TestCaseRequest;
import com.example.qacraft_test_management.dto.TestCaseResponse;
import com.example.qacraft_test_management.entity.TestCase;
import org.springframework.stereotype.Component;

@Component
public class TestCaseMapper {
    public TestCase toEntity(TestCaseRequest request) {
        TestCase testCase = new TestCase();

        testCase.setTitle(request.getTitle());
        testCase.setDescription(request.getDescription());
        testCase.setPreconditions(request.getPreconditions());
        testCase.setSteps(request.getSteps());
        testCase.setExpectedResult(request.getExpectedResult());
        testCase.setPriority(request.getPriority());
        testCase.setStatus(request.getStatus());

        return testCase;
    }

    public void updateEntity(TestCase testCase, TestCaseRequest request) {
        testCase.setTitle(request.getTitle());
        testCase.setDescription(request.getDescription());
        testCase.setPreconditions(request.getPreconditions());
        testCase.setSteps(request.getSteps());
        testCase.setExpectedResult(request.getExpectedResult());
        testCase.setPriority(request.getPriority());
        testCase.setStatus(request.getStatus());
    }

    public TestCaseResponse toResponse(TestCase testCase) {
        TestCaseResponse response = new TestCaseResponse();

        response.setId(testCase.getId());
        response.setTitle(testCase.getTitle());
        response.setDescription(testCase.getDescription());
        response.setPreconditions(testCase.getPreconditions());
        response.setSteps(testCase.getSteps());
        response.setExpectedResult(testCase.getExpectedResult());
        response.setPriority(testCase.getPriority());
        response.setStatus(testCase.getStatus());
        response.setCreatedAt(testCase.getCreatedAt());
        response.setUpdatedAt(testCase.getUpdatedAt());

        return response;
    }
}
