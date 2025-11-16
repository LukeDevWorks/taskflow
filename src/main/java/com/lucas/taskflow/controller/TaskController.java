package com.lucas.taskflow.controller;

import com.lucas.taskflow.model.Task;
import com.lucas.taskflow.model.User;
import com.lucas.taskflow.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Crear tarea
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Obtener todas las tareas de un usuario
    @GetMapping("/user/{username}")
    public List<Task> getTasks(@PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        return taskService.getTasksByUser(user);
    }

    // Obtener tarea por ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).orElse(null);
    }

    // Actualizar tarea
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    // Eliminar tarea
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
