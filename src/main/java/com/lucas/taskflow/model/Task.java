package com.lucas.taskflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private boolean completed = false;

    private LocalDateTime createdAt;

    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    // Relación con User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
