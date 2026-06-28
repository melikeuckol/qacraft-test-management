package com.example.qacraft_test_management.repo;

import com.example.qacraft_test_management.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepo extends JpaRepository<TestCase,Long> {

}
