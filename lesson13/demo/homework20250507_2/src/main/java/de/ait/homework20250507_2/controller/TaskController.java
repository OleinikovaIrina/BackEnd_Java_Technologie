package de.ait.homework20250507_2.controller;

import de.ait.homework20250507_2.model.Task;
import de.ait.homework20250507_2.repository.TaskDB;
import de.ait.homework20250507_2.repository.TaskRepository;
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
    public Task getById(@PathVariable(name = "id") Long idTask) {
        return repository.findById(idTask);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public List<Task> deleteById(@PathVariable(name = "id") Long idTask) {

        return repository.deleteById(idTask);
    }
}

