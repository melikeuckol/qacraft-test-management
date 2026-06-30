package com.example.qacraft_test_management.service;

import com.example.qacraft_test_management.dto.DashboardResponse;
import com.example.qacraft_test_management.enums.BugSeverity;
import com.example.qacraft_test_management.enums.BugStatus;
import com.example.qacraft_test_management.enums.ExecutionStatus;
import com.example.qacraft_test_management.repo.BugRepo;
import com.example.qacraft_test_management.repo.TestCaseRepo;
import com.example.qacraft_test_management.repo.TestExecutionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final TestCaseRepo testCaseRepository;
    private final TestExecutionRepo testExecutionRepository;
    private final BugRepo bugRepository;

    @Override
    public DashboardResponse getDashboard() {
        long totalTestCases = testCaseRepository.count();

        long totalExecutions = testExecutionRepository.count();
        long passedExecutions = testExecutionRepository.countByStatus(ExecutionStatus.PASSED);
        long failedExecutions = testExecutionRepository.countByStatus(ExecutionStatus.FAILED);
        long blockedExecutions = testExecutionRepository.countByStatus(ExecutionStatus.BLOCKED);

        long openBugs = bugRepository.countByStatus(BugStatus.OPEN);
        long criticalBugs = bugRepository.countBySeverity(BugSeverity.CRITICAL);

        double passRate = totalExecutions == 0
                ? 0
                : ((double) passedExecutions / totalExecutions) * 100;

        double failRate = totalExecutions == 0
                ? 0
                : ((double) failedExecutions / totalExecutions) * 100;

        DashboardResponse response = new DashboardResponse();

        response.setTotalTestCases(totalTestCases);
        response.setTotalExecutions(totalExecutions);
        response.setPassedExecutions(passedExecutions);
        response.setFailedExecutions(failedExecutions);
        response.setBlockedExecutions(blockedExecutions);
        response.setPassRate(passRate);
        response.setFailRate(failRate);
        response.setOpenBugs(openBugs);
        response.setCriticalBugs(criticalBugs);

        response.setAverageExecutionTime(0.0);

        return response;
    }
}
