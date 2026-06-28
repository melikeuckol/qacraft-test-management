package com.example.qacraft_test_management.controller;

import com.example.qacraft_test_management.dto.BugRequest;
import com.example.qacraft_test_management.dto.BugResponse;
import com.example.qacraft_test_management.service.BugService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bugs")
@RequiredArgsConstructor
public class BugController {
    private final BugService bugService;

    @PostMapping
    public BugResponse createBug(@Valid @RequestBody BugRequest request) {
        return bugService.createBug(request);
    }

    @GetMapping
    public List<BugResponse> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/{id}")
    public BugResponse getBugById(@PathVariable Long id) {
        return bugService.getBugById(id);
    }

    @PutMapping("/{id}")
    public BugResponse updateBug(
            @PathVariable Long id,
            @Valid @RequestBody BugRequest request
    ) {
        return bugService.updateBug(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBug(@PathVariable Long id) {
        bugService.deleteBug(id);
    }

}
