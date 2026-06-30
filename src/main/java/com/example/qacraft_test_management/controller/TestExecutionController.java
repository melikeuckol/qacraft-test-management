package com.example.qacraft_test_management.controller;

import com.example.qacraft_test_management.dto.TestExecutionRequest;
import com.example.qacraft_test_management.dto.TestExecutionResponse;
import com.example.qacraft_test_management.service.TestExecutionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-executions")
@RequiredArgsConstructor
public class TestExecutionController {
    private final TestExecutionService testExecutionService;

    @PostMapping
    public TestExecutionResponse createExecution(@Valid @RequestBody TestExecutionRequest request) {
        return testExecutionService.createExecution(request);
    }

    @GetMapping
    public List<TestExecutionResponse> getAllExecutions() {
        return testExecutionService.getAllExecutions();
    }

    @GetMapping("/{id}")
    public TestExecutionResponse getExecutionById(@PathVariable Long id) {
        return testExecutionService.getExecutionById(id);
    }

    @PutMapping("/{id}")
    public TestExecutionResponse updateExecution(
            @PathVariable Long id,
            @Valid @RequestBody TestExecutionRequest request
    ) {
        return testExecutionService.updateExecution(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteExecution(@PathVariable Long id) {
        testExecutionService.deleteExecution(id);
    }



}
