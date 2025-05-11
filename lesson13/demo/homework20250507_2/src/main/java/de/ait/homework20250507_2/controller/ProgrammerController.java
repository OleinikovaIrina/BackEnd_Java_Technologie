package de.ait.homework20250507_2.controller;

import de.ait.homework20250507_2.model.Programmer;
import de.ait.homework20250507_2.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class ProgrammerController {

    private final ProgrammerRepository repository;

    @Autowired
    public ProgrammerController(ProgrammerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/programmers")
    public List<Programmer> getProgrammers() {
        return repository.findAllProgrammers();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable Long id) {
        return repository.findProgrammerById(id);
    }

    @PostMapping("/programmer")
    public Programmer addProgrammer(@RequestBody Programmer programmer) {
        return repository.saveProgrammer(programmer);
    }

    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public Programmer addTaskId(@PathVariable Long programmerId, @PathVariable Long taskId) {
        return repository.addTaskToProgrammer(programmerId, taskId);
    }



    @DeleteMapping("/programmers/{programmerId}/tasks/{taskId}")
    public Programmer deleteTaskId(@PathVariable Long programmerId, @PathVariable Long taskId) {
        return repository.deleteTaskToProgrammer(programmerId, taskId);
    }


    @GetMapping("/programmers/{id}/tasks")
    public Map<Long, String> getTasksById(@PathVariable Long id) {
        return repository.findTaskById(id);
    }


}



