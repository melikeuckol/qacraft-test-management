package com.example.qacraft_test_management.mapper;

import com.example.qacraft_test_management.dto.BugRequest;
import com.example.qacraft_test_management.dto.BugResponse;
import com.example.qacraft_test_management.entity.Bug;
import org.springframework.stereotype.Component;

@Component
public class BugMapper {
    public Bug toEntity(BugRequest request){
        Bug bug=new Bug();

        bug.setTitle(request.getTitle());
        bug.setDescription(request.getDescription());
        bug.setSeverity(request.getSeverity());
        bug.setPriority(request.getPriority());
        bug.setReporter(request.getReporter());
        bug.setAssignee(request.getAssignee());
        bug.setEnvironment(request.getEnvironment());
        bug.setBrowser(request.getBrowser());
        bug.setOperatingSystem(request.getOperatingSystem());
        bug.setStepsToReproduce(request.getStepsToReproduce());
        bug.setExpectedResult(request.getExpectedResult());
        bug.setActualResult(request.getActualResult());
        bug.setStatus(request.getStatus());

        return bug;
    }

    public void updateEntity(Bug bug,BugRequest request){
        bug.setTitle(request.getTitle());
        bug.setDescription(request.getDescription());
        bug.setSeverity(request.getSeverity());
        bug.setPriority(request.getPriority());
        bug.setReporter(request.getReporter());
        bug.setAssignee(request.getAssignee());
        bug.setEnvironment(request.getEnvironment());
        bug.setBrowser(request.getBrowser());
        bug.setOperatingSystem(request.getOperatingSystem());
        bug.setStepsToReproduce(request.getStepsToReproduce());
        bug.setExpectedResult(request.getExpectedResult());
        bug.setActualResult(request.getActualResult());

    }

    public BugResponse toResponse(Bug bug){
        BugResponse response=new BugResponse();

        if (bug.getTestExecution() != null) {

            response.setTestExecutionId(
                    bug.getTestExecution().getId());

            response.setExecutionStatus(
                    bug.getTestExecution().getStatus());

            response.setTestCaseId(
                    bug.getTestExecution().getTestCase().getId());

            response.setTestCaseTitle(
                    bug.getTestExecution().getTestCase().getTitle());
        }
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
        response.setCreatedAt(bug.getCreatedAt());
        response.setUpdatedAt(bug.getUpdatedAt());


        return response;
    }
}
