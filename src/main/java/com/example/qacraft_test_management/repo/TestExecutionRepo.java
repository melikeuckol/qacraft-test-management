package com.example.qacraft_test_management.repo;

import com.example.qacraft_test_management.entity.TestExecution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestExecutionRepo extends JpaRepository<TestExecution,Long> {
    List<TestExecution> findByTestCaseId(Long testCaseId);
}
