package com.example.qacraft_test_management.repo;

import com.example.qacraft_test_management.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepo extends JpaRepository<Bug,Long> {

}
