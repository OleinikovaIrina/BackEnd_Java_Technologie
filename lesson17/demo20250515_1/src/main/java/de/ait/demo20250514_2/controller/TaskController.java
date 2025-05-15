package de.ait.demo20250514_2.controller;

import de.ait.demo20250514_2.dto.TaskRequestDto;
import de.ait.demo20250514_2.dto.TaskResponseDto;
import de.ait.demo20250514_2.model.Task;
import de.ait.demo20250514_2.repository.TaskRepository;
import de.ait.demo20250514_2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

@RestController
public class TaskController {
    private final TaskService service;
    private final TaskRepository repository; // repository temporary

    private Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, TaskService service) {
        this.repository = repository;
        this.service = service;

    }


    @GetMapping("/tasks")
    public ResponseEntity< List<TaskResponseDto> > getTasks(){
        return ResponseEntity.ok(service.getAllTasks());
    }

    // если ok то 200OK и TaskResponseDto   иначе  404NotFound
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long taskId){
        TaskResponseDto taskById = service.getTaskById(taskId);
        //return (taskById!=null)? ResponseEntity.ok(taskById) : ResponseEntity.notFound().build();

        return ResponseEntity.ofNullable(taskById);
    }


    @PostMapping("/tasks")
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody TaskRequestDto task){
        TaskResponseDto savedTask = service.createTask(task);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedTask);
/*
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                //.header("location", location.toString())
                .body(savedTask);
*/

    }

    /*
    A successful response SHOULD be 200 (OK) if the response includes an entity
    describing the status, 202 (Accepted) if the action has not yet been enacted,
    or 204 (No Content) if the action has been enacted but the response
    does not include an entity.
     */

    @DeleteMapping("/tasks/{id}")
    public  ResponseEntity<TaskResponseDto> deleteTaskById(@PathVariable("id") Long id){
        TaskResponseDto deletedTask = service.deleteTask(id);
        return ResponseEntity.ofNullable(deletedTask);
    }




}