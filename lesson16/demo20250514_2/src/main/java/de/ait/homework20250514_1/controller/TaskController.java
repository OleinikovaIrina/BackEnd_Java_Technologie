package de.ait.homework20250514_1.controller;

import de.ait.homework20250514_1.dto.TaskRequestDto;
import de.ait.homework20250514_1.dto.TaskResponseDto;
import de.ait.homework20250514_1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
