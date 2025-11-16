package com.lucas.taskflow.service.impl;

import com.lucas.taskflow.model.Task;
import com.lucas.taskflow.model.User;
import com.lucas.taskflow.repository.TaskRepository;
import com.lucas.taskflow.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByUserAndStatus(User user, boolean completed) {
        return taskRepository.findByUserAndCompleted(user, completed);
    }

    @Override
    public List<Task> getTasksOrderedByDueDate(User user) {
        return taskRepository.findByUserOrderByDueDateAsc(user);
    }
}
