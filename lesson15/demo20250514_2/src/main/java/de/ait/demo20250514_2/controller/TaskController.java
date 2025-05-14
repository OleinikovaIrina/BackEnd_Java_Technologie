package de.ait.demo20250514_2.controller;

import de.ait.demo20250514_2.dto.TaskResponseDto;
import de.ait.demo20250514_2.model.Task;
import de.ait.demo20250514_2.repository.TaskRepository;
import de.ait.demo20250514_2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

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
        //return ResponseEntity.ok(service.getAllTasks());

        List<TaskResponseDto> allTasks = service.getAllTasks();
        HttpHeaders headers = new HttpHeaders(); // заголовки HTTP
        headers.add("X-Task-Size", String.valueOf(allTasks.size()));
        headers.add("X-Task-Hello", "hello from server");
        return new ResponseEntity<>(allTasks,headers, HttpStatus.OK);
    }


    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId){
        try {
            return ResponseEntity.ok(repository.findById(taskId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task, UriComponentsBuilder uriBuilder){
        Task saveed = repository.save(task);
        /*
        try {
            return ResponseEntity.created(new URI("http://localhost:8081/tasks/"+saveed.getId())).body(saveed);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        */
        // возвращаем статус 201 Created + header Location с адресом ресурса
        ResponseEntity<Task> entity
                = ResponseEntity
                .created(UriComponentsBuilder.fromPath("/tasks/{id}")
                        .buildAndExpand(saveed.getId())
                        .toUri())
                .body(saveed);
        return entity;
    }

    @DeleteMapping("/tasks/{id}")
    public  Task deleteTaskById(@PathVariable("id") Long id){
        return repository.delete(id);
    }




}

