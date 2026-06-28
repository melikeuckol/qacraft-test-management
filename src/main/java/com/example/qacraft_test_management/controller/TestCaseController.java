package com.example.qacraft_test_management.controller;

import com.example.qacraft_test_management.dto.TestCaseRequest;
import com.example.qacraft_test_management.dto.TestCaseResponse;
import com.example.qacraft_test_management.service.TestCaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-cases")
@RequiredArgsConstructor
public class TestCaseController {
    private final TestCaseService testCaseService;

    @PostMapping
    public TestCaseResponse createTestCase(@Valid @RequestBody TestCaseRequest request) {
        return testCaseService.createTestCase(request);
    }

    @GetMapping
    public List<TestCaseResponse> getAllTestCases() {
        return testCaseService.getAllTestCases();
    }

    @GetMapping("/{id}")
    public TestCaseResponse getTestCaseById(@PathVariable Long id) {
        return testCaseService.getTestCaseById(id);
    }

    @PutMapping("/{id}")
    public TestCaseResponse updateTestCase(
            @PathVariable Long id,
            @Valid
            @RequestBody TestCaseRequest request
    ) {
        return testCaseService.updateTestCase(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
    }

}
