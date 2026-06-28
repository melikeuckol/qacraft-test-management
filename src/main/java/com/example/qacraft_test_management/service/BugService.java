package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.BugRequest;
import com.example.qacraft_test_management.dto.BugResponse;

import java.util.List;

public interface BugService {

    BugResponse createBug(BugRequest request);

    List<BugResponse> getAllBugs();

    BugResponse getBugById(Long id);

    BugResponse updateBug(Long id, BugRequest request);

    void deleteBug(Long id);

}
