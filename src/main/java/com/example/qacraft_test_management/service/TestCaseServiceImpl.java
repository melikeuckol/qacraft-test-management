package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.TestCaseRequest;
import com.example.qacraft_test_management.dto.TestCaseResponse;
import com.example.qacraft_test_management.entity.TestCase;
import com.example.qacraft_test_management.repo.TestCaseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepo testCaseRepository;

    @Override
    public TestCaseResponse createTestCase(TestCaseRequest request) {
        TestCase testCase = new TestCase();

        testCase.setTitle(request.getTitle());
        testCase.setDescription(request.getDescription());
        testCase.setPreconditions(request.getPreconditions());
        testCase.setSteps(request.getSteps());
        testCase.setExpectedResult(request.getExpectedResult());
        testCase.setPriority(request.getPriority());
        testCase.setStatus(request.getStatus());

        TestCase savedTestCase = testCaseRepository.save(testCase);

        return mapToResponse(savedTestCase);
    }

    @Override
    public List<TestCaseResponse> getAllTestCases() {
        return testCaseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TestCaseResponse getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + id));

        return mapToResponse(testCase);
    }

    @Override
    public TestCaseResponse updateTestCase(Long id, TestCaseRequest request) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + id));

        testCase.setTitle(request.getTitle());
        testCase.setDescription(request.getDescription());
        testCase.setPreconditions(request.getPreconditions());
        testCase.setSteps(request.getSteps());
        testCase.setExpectedResult(request.getExpectedResult());
        testCase.setPriority(request.getPriority());
        testCase.setStatus(request.getStatus());

        TestCase updatedTestCase = testCaseRepository.save(testCase);

        return mapToResponse(updatedTestCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + id));

        testCaseRepository.delete(testCase);
    }

    private TestCaseResponse mapToResponse(TestCase testCase) {
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
