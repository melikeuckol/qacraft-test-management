package com.example.qacraft_test_management.repo;

import com.example.qacraft_test_management.entity.Bug;
import com.example.qacraft_test_management.enums.BugSeverity;
import com.example.qacraft_test_management.enums.BugStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepo extends JpaRepository<Bug,Long> {
    long countByStatus(BugStatus status);

    long countBySeverity(BugSeverity severity);
}
