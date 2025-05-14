package de.ait.demo20250512_1.controller;

import de.ait.demo20250512_1.dto.TaskRequestDto;
import de.ait.demo20250512_1.dto.TaskResponseDto;
import de.ait.demo20250512_1.model.Task;
import de.ait.demo20250512_1.repository.TaskRepository;
import de.ait.demo20250512_1.repository.TaskRepositoryMapImpl;
import de.ait.demo20250512_1.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@RestController
public class TaskController {
//    private final TaskRepository repository;
    private final TaskService service;


//    private Scanner scanner;
//
//    @Autowired
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }
//
//    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository) {
//        this.repository = repository;
//
//    }


//    @GetMapping("/tasks")
//    public List<Task> getTasks(){
//        System.out.println("input");
//        String s = scanner.nextLine();
//        System.out.println(s);
//        return repository.findAll();
//    }


    @GetMapping("/tasks/{id}")
    public TaskResponseDto getTaskById(@PathVariable("id") Long taskId){
        return service.getTaskById(taskId);
    }

    @PostMapping("/tasks")
    public TaskResponseDto createNewTask(@RequestBody TaskRequestDto dto){

        return service.createTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public  TaskResponseDto deleteTaskById(@PathVariable("id") Long id){
        return service.deleteTask(id);
    }




}
