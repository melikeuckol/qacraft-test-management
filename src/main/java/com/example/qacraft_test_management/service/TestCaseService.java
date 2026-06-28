package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.TestCaseRequest;
import com.example.qacraft_test_management.dto.TestCaseResponse;

import java.util.List;

public interface TestCaseService {
    TestCaseResponse createTestCase(TestCaseRequest request);

    List<TestCaseResponse> getAllTestCases();

    TestCaseResponse getTestCaseById(Long id);

    TestCaseResponse updateTestCase(Long id, TestCaseRequest request);

    void deleteTestCase(Long id);
}
