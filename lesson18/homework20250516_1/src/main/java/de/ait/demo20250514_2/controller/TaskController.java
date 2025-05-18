package de.ait.demo20250514_2.controller;

import de.ait.demo20250514_2.dto.TaskRequestDto;
import de.ait.demo20250514_2.dto.TaskResponseDto;

import de.ait.demo20250514_2.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;


    @GetMapping()
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    // если ok то 200OK и TaskResponseDto   иначе  404NotFound
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long taskId) {
        TaskResponseDto taskById = service.getTaskById(taskId);
        return ResponseEntity.ofNullable(taskById);
    }


    @PostMapping
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody TaskRequestDto task) {
        TaskResponseDto savedTask = service.saveTask(task);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedTask);


    }


}




