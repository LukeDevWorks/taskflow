package com.lucas.taskflow.controller;

import com.lucas.taskflow.model.Task;
import com.lucas.taskflow.model.User;
import com.lucas.taskflow.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        // Obtener el usuario autenticado desde el contexto
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        // Asignarlo a la tarea
        task.setUser(user);

        return taskService.createTask(task);
    }

    // Obtener todas las tareas del usuario autenticado
    @GetMapping
    public List<Task> getMyTasks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        return taskService.getTasksByUser(user);
    }

    // Obtener por id (opcional mejorar)
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
