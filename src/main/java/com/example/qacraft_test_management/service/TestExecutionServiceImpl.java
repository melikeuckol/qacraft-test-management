package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.TestExecutionRequest;
import com.example.qacraft_test_management.dto.TestExecutionResponse;
import com.example.qacraft_test_management.entity.TestCase;
import com.example.qacraft_test_management.entity.TestExecution;
import com.example.qacraft_test_management.mapper.TestExecutionMapper;
import com.example.qacraft_test_management.repo.TestCaseRepo;
import com.example.qacraft_test_management.repo.TestExecutionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestExecutionServiceImpl implements TestExecutionService{
    private final TestExecutionRepo testExecutionRepository;
    private final TestCaseRepo testCaseRepository;
    private final TestExecutionMapper testExecutionMapper;

    @Override
    public TestExecutionResponse createExecution(TestExecutionRequest request) {

        TestExecution execution = testExecutionMapper.toEntity(request);
        TestCase testCase = testCaseRepository.findById(request.getTestCaseId())
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + request.getTestCaseId()));

        execution.setTestCase(testCase);

        TestExecution savedExecution = testExecutionRepository.save(execution);

        return testExecutionMapper.toResponse(savedExecution);
    }

    @Override
    public List<TestExecutionResponse> getAllExecutions() {
        return testExecutionRepository.findAll()
                .stream()
                .map(testExecutionMapper::toResponse)
                .toList();
    }

    @Override
    public TestExecutionResponse getExecutionById(Long id) {
        TestExecution execution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + id));

        return testExecutionMapper.toResponse(execution);
    }

    @Override
    public TestExecutionResponse updateExecution(Long id, TestExecutionRequest request) {
        TestExecution execution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + id));


        testExecutionMapper.updateEntity(execution,request);
        TestCase testCase = testCaseRepository.findById(request.getTestCaseId())
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + request.getTestCaseId()));

        execution.setTestCase(testCase);

        TestExecution updatedExecution = testExecutionRepository.save(execution);
        return testExecutionMapper.toResponse(updatedExecution);
    }

    @Override
    public void deleteExecution(Long id) {
        TestExecution execution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + id));

        testExecutionRepository.delete(execution);
    }


    @Override
    public List<TestExecutionResponse> getExecutionsByTestCaseId(Long testCaseId) {

        return testExecutionRepository.findByTestCaseId(testCaseId)
                .stream()
                .map(testExecutionMapper::toResponse)
                .collect(Collectors.toList());
    }

}
