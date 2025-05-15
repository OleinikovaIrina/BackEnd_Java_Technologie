package de.ait.homework20250514_1.controller;

import de.ait.homework20250514_1.dto.TaskRequestDto;
import de.ait.homework20250514_1.dto.TaskResponseDto;
import de.ait.homework20250514_1.model.Task;
import de.ait.homework20250514_1.repository.TaskRepository;
import de.ait.homework20250514_1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@RestController
public class TaskController {
    private final TaskRepository repository;
    private final TaskService service;


//    private Scanner scanner;
//
//    @Autowired
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }

//    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository) {
//            this.repository = repository;
//        this.service = service;
//    }


    @GetMapping("/tasks")
    public ResponseEntity< List<TaskResponseDto> > getTasks(){
        //return ResponseEntity.ok(service.getAllTasks());

        List<TaskResponseDto> allTasks = service.getAllTasks();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-TaskOfSize", String.valueOf(allTasks.size()));
        return new ResponseEntity<>(allTasks,headers, HttpStatus.OK);
    }


    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long taskId){
        try {
            return ResponseEntity.ok(service.getTaskById(taskId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tasks")
    public TaskResponseDto createNewTask(@RequestBody TaskRequestDto dto){

        return service.createTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public  ResponseEntity<TaskResponseDto>deleteTaskById(@PathVariable("id") Long id){
        try {
                return ResponseEntity.ok(service.deleteTask(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }


    }


}
