package com.lucas.taskflow.repository;

import com.lucas.taskflow.model.Task;
import com.lucas.taskflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

    List<Task> findByUserAndCompleted(User user, boolean completed);

    List<Task> findByUserOrderByDueDateAsc(User user);
}
