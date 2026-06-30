package com.example.qacraft_test_management.entity;

import com.example.qacraft_test_management.enums.BugSeverity;
import com.example.qacraft_test_management.enums.BugStatus;
import com.example.qacraft_test_management.enums.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bugs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private BugSeverity severity;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private BugStatus status;

    private String reporter;
    private String assignee;
    private String environment;
    private String browser;
    private String operatingSystem;

    @Column(length = 2000)
    private String stepsToReproduce;

    @Column(length = 1000)
    private String expectedResult;

    @Column(length = 1000)
    private String actualResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_execution_id", nullable = false)
    private TestExecution testExecution;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (status == null) {
            status = BugStatus.OPEN;
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
