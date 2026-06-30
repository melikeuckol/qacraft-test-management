package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.TestCaseRequest;
import com.example.qacraft_test_management.dto.TestCaseResponse;
import com.example.qacraft_test_management.entity.TestCase;
import com.example.qacraft_test_management.mapper.TestCaseMapper;
import com.example.qacraft_test_management.repo.TestCaseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepo testCaseRepository;
    private final TestCaseMapper testCaseMapper;

    @Override
    public TestCaseResponse createTestCase(TestCaseRequest request) {
        TestCase testCase = testCaseMapper.toEntity(request);
        TestCase savedTestCase=testCaseRepository.save(testCase);
        return testCaseMapper.toResponse(testCase);
    }

    @Override
    public List<TestCaseResponse> getAllTestCases() {
        return testCaseRepository.findAll()
                .stream()
                .map(testCaseMapper::toResponse)
                .toList();
    }

    @Override
    public TestCaseResponse getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + id));

        return testCaseMapper.toResponse(testCase);
    }

    @Override
    public TestCaseResponse updateTestCase(Long id, TestCaseRequest request) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + id));

        testCaseMapper.updateEntity(testCase, request);
        TestCase updatedTestCase = testCaseRepository.save(testCase);
        return testCaseMapper.toResponse(updatedTestCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found with id: " + id));

        testCaseRepository.delete(testCase);
    }

}
