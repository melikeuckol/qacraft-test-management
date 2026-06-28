package com.example.qacraft_test_management.entity;

import com.example.qacraft_test_management.enums.Priority;
import com.example.qacraft_test_management.enums.TestCaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

    @Entity
    @Table(name = "test_cases")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class TestCase {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        @Column(length = 1000)
        private String description;

        @Column(length = 1000)
        private String preconditions;

        @Column(length = 2000)
        private String steps;

        @Column(length = 1000)
        private String expectedResult;

        @Enumerated(EnumType.STRING)
        private Priority priority;

        @Enumerated(EnumType.STRING)
        private TestCaseStatus status;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

        @PrePersist
        public void onCreate() {
            createdAt = LocalDateTime.now();
            updatedAt = LocalDateTime.now();
        }

        @PreUpdate
        public void onUpdate() {
            updatedAt = LocalDateTime.now();
        }
}
