package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.BugRequest;
import com.example.qacraft_test_management.dto.BugResponse;
import com.example.qacraft_test_management.entity.Bug;
import com.example.qacraft_test_management.entity.TestExecution;
import com.example.qacraft_test_management.mapper.BugMapper;
import com.example.qacraft_test_management.repo.BugRepo;
import com.example.qacraft_test_management.repo.TestExecutionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService{
    private final BugRepo bugRepository;
    private final TestExecutionRepo testExecutionRepository;
    private final BugMapper bugMapper;

    @Override
    public BugResponse createBug(BugRequest request) {
        Bug bug = bugMapper.toEntity(request);
        TestExecution execution = testExecutionRepository.findById(request.getTestExecutionId())
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + request.getTestExecutionId()));
        bug.setTestExecution(execution);
        Bug savedBug = bugRepository.save(bug);

        return bugMapper.toResponse(savedBug);
    }

    @Override
    public List<BugResponse> getAllBugs() {
        return bugRepository.findAll()
                .stream()
                .map(bugMapper::toResponse)
                .toList();
    }

    @Override
    public BugResponse getBugById(Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

        return bugMapper.toResponse(bug);
    }

    @Override
    public BugResponse updateBug(Long id, BugRequest request) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

       bugMapper.updateEntity(bug,request);
       TestExecution execution = testExecutionRepository.findById(request.getTestExecutionId())
                .orElseThrow(() -> new RuntimeException("Test execution not found with id: " + request.getTestExecutionId()));

       bug.setTestExecution(execution);

       Bug updatedBug = bugRepository.save(bug);

        return bugMapper.toResponse(updatedBug);
    }

    @Override
    public void deleteBug(Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

        bugRepository.delete(bug);
    }

}
