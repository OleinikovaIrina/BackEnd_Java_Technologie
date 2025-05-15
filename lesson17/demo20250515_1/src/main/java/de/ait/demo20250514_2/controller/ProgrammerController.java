package de.ait.demo20250514_2.controller;

import de.ait.demo20250514_2.dto.ProgrammerResponseDto;
import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.model.Task;
import de.ait.demo20250514_2.repository.ProgrammerRepository;
import de.ait.demo20250514_2.service.ProgrammerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@AllArgsConstructor
public class ProgrammerController {

    private final ProgrammerRepository repository;
    private final ProgrammerService service;


    @GetMapping("/programmers")
    public List<ProgrammerResponseDto> getProgrammers(){
        return service.getAllProgrammer();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable("id") Long id){
        return repository.findById(id);
    }




    //получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByProgrammer(@PathVariable("id") Long id){
        return ResponseEntity.ok(repository.findTasksByProgrammerId(id));
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTaskToProgrammer(@PathVariable("programmerId") Long programmerID, @PathVariable("taskId") Long taskId){
        repository.addTaskToProgrammer(programmerID,taskId);
    }

}
