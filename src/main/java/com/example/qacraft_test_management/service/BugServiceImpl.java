package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.BugRequest;
import com.example.qacraft_test_management.dto.BugResponse;
import com.example.qacraft_test_management.entity.Bug;
import com.example.qacraft_test_management.entity.TestCase;
import com.example.qacraft_test_management.enums.BugStatus;
import com.example.qacraft_test_management.repo.BugRepo;
import com.example.qacraft_test_management.repo.TestCaseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService{
    private final BugRepo bugRepository;
    private final TestCaseRepo testCaseRepository;

    @Override
    public BugResponse createBug(BugRequest request) {
        Bug bug = new Bug();

        setBugFields(bug, request);

        Bug savedBug = bugRepository.save(bug);

        return mapToResponse(savedBug);
    }

    @Override
    public List<BugResponse> getAllBugs() {
        return bugRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public BugResponse getBugById(Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

        return mapToResponse(bug);
    }

    @Override
    public BugResponse updateBug(Long id, BugRequest request) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

        setBugFields(bug, request);

        Bug updatedBug = bugRepository.save(bug);

        return mapToResponse(updatedBug);
    }

    @Override
    public void deleteBug(Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

        bugRepository.delete(bug);
    }

    private void setBugFields(Bug bug, BugRequest request) {
        bug.setTitle(request.getTitle());
        bug.setDescription(request.getDescription());
        bug.setSeverity(request.getSeverity());
        bug.setPriority(request.getPriority());

        if (request.getStatus() != null) {
            bug.setStatus(request.getStatus());
        } else if (bug.getStatus() == null) {
            bug.setStatus(BugStatus.OPEN);
        }

        bug.setReporter(request.getReporter());
        bug.setAssignee(request.getAssignee());
        bug.setEnvironment(request.getEnvironment());
        bug.setBrowser(request.getBrowser());
        bug.setOperatingSystem(request.getOperatingSystem());
        bug.setStepsToReproduce(request.getStepsToReproduce());
        bug.setExpectedResult(request.getExpectedResult());
        bug.setActualResult(request.getActualResult());

        if (request.getTestCaseId() != null) {
            TestCase testCase = testCaseRepository.findById(request.getTestCaseId())
                    .orElseThrow(() -> new RuntimeException("Test case not found with id: " + request.getTestCaseId()));

            bug.setTestCase(testCase);
        }
    }

    private BugResponse mapToResponse(Bug bug) {
        BugResponse response = new BugResponse();

        response.setId(bug.getId());
        response.setTitle(bug.getTitle());
        response.setDescription(bug.getDescription());
        response.setSeverity(bug.getSeverity());
        response.setPriority(bug.getPriority());
        response.setStatus(bug.getStatus());

        response.setReporter(bug.getReporter());
        response.setAssignee(bug.getAssignee());
        response.setEnvironment(bug.getEnvironment());
        response.setBrowser(bug.getBrowser());
        response.setOperatingSystem(bug.getOperatingSystem());

        response.setStepsToReproduce(bug.getStepsToReproduce());
        response.setExpectedResult(bug.getExpectedResult());
        response.setActualResult(bug.getActualResult());

        if (bug.getTestCase() != null) {
            response.setTestCaseId(bug.getTestCase().getId());
            response.setTestCaseTitle(bug.getTestCase().getTitle());
        }

        response.setCreatedAt(bug.getCreatedAt());
        response.setUpdatedAt(bug.getUpdatedAt());

        return response;
    }

}
