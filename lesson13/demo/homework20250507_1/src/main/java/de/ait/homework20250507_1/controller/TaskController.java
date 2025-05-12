package de.ait.homework20250507_1.controller;

import de.ait.homework20250507_1.model.Task;
import de.ait.homework20250507_1.repository.TaskDB;
import de.ait.homework20250507_1.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskRepository repository = new TaskDB();


    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getById(@PathVariable(name = "id") Long id) {
        return repository.findById(id);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public List<Task> deleteById(@PathVariable(name = "id") Long id) {
        System.out.println("Контроллер получил DELETE для ID: " + id);
        return repository.deleteById(id);
    }
}

