package com.example.qacraft_test_management.entity;

import com.example.qacraft_test_management.enums.ExecutionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "test_executions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String executor;

    private LocalDateTime executionDate;

    @Enumerated(EnumType.STRING)
    private ExecutionStatus status;

    private Long executionTimeInSeconds;

    @Column(length = 1500)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_case_id", nullable = false)
    private TestCase testCase;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (executionDate == null) {
            executionDate = LocalDateTime.now();
        }

        if (status == null) {
            status = ExecutionStatus.NOT_EXECUTED;
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
