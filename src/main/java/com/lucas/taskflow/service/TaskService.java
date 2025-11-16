package com.lucas.taskflow.service;

import com.lucas.taskflow.model.Task;
import com.lucas.taskflow.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getTasksByUser(User user);

    Optional<Task> getTaskById(Long id);

    Task updateTask(Task task);

    void deleteTask(Long id);

    List<Task> getTasksByUserAndStatus(User user, boolean completed);

    List<Task> getTasksOrderedByDueDate(User user);
}
