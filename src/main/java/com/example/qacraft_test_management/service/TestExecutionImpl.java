package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.TestExecutionRequest;
import com.example.qacraft_test_management.dto.TestExecutionResponse;
import com.example.qacraft_test_management.entity.TestCase;
import com.example.qacraft_test_management.entity.TestExecution;
import com.example.qacraft_test_management.repo.TestCaseRepo;
import com.example.qacraft_test_management.repo.TestExecutionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestExecutionImpl implements TestExecutionService{
    private final TestExecutionRepo testExecutionRepository;
    private final TestCaseRepo testCaseRepository;

    @Override
    public TestExecutionResponse createExecution(TestExecutionRequest request) {
        TestExecution execution = new TestExecution();

        setExecutionFields(execution, request);

        TestExecution savedExecution = testExecutionRepository.save(execution);

        return mapToResponse(savedExecution);
    }

    @Override
    public List<TestExecutionResponse> getAllExecutions() {
        return testExecutionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TestExecutionResponse getExecutionById(Long id) {
        TestExecution execution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + id));

        return mapToResponse(execution);
    }

    @Override
    public TestExecutionResponse updateExecution(Long id, TestExecutionRequest request) {
        TestExecution execution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + id));

        setExecutionFields(execution, request);

        TestExecution updatedExecution = testExecutionRepository.save(execution);

        return mapToResponse(updatedExecution);
    }

    @Override
    public void deleteExecution(Long id) {
        TestExecution execution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + id));

        testExecutionRepository.delete(execution);
    }

    private void setExecutionFields(TestExecution execution, TestExecutionRequest request) {
        TestCase testCase = testCaseRepository.findById(request.getTestCaseId())
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + request.getTestCaseId()));

        execution.setTestCase(testCase);
        execution.setExecutor(request.getExecutor());
        execution.setStatus(request.getStatus());
        execution.setExecutionTimeInSeconds(request.getExecutionTimeInSeconds());
        execution.setNotes(request.getNotes());
    }

    @Override
    public List<TestExecutionResponse> getExecutionsByTestCaseId(Long testCaseId) {

        return testExecutionRepository.findByTestCaseId(testCaseId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private TestExecutionResponse mapToResponse(TestExecution execution) {
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
