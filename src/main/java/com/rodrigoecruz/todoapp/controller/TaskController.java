package com.rodrigoecruz.todoapp.controller;

import com.rodrigoecruz.todoapp.dto.NewTaskDTO;
import com.rodrigoecruz.todoapp.dto.TaskDTO;
import com.rodrigoecruz.todoapp.entity.TaskStatus;
import com.rodrigoecruz.todoapp.service.ITaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo Cruz
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskService service;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody NewTaskDTO dto) {
        TaskDTO response = service.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        List<TaskDTO> response = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<TaskDTO>> getAllByTaskStatus(@PathVariable TaskStatus status) {
        List<TaskDTO> response = service.getAllByTaskStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> markTaskAsFinished(@PathVariable Long id) {
        service.markTaskAsFinished(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
