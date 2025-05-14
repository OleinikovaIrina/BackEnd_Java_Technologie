package de.ait.demo20250512_1.controller;

import de.ait.demo20250512_1.dto.ProgrammerResponseDto;
import de.ait.demo20250512_1.model.Programmer;

import de.ait.demo20250512_1.model.Task;

import de.ait.demo20250512_1.repository.ProgrammerRepository;
import de.ait.demo20250512_1.repository.ProgrammerRepositoryMapImpl;
import de.ait.demo20250512_1.repository.ProgrammerRepository;
import de.ait.demo20250512_1.service.ProgrammerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequiredArgsConstructor
public class ProgrammerController {

    private final ProgrammerRepository repository;
    private final ProgrammerService service;


    @GetMapping("/programmers")
    public List<ProgrammerResponseDto> getProgrammers() {
        return service.getAllProgrammers();
    }

    @GetMapping("/programmers/{id}")
    public ProgrammerResponseDto getProgrammerById(@PathVariable("id") Long id) {
        return service.getProgrammerById(id);
    }

//
//    //получить список задач заданного программиста (GET programmers/id/tasks)
//    @GetMapping("/programmers/{id}/tasks")
//    public List<Task> getTaskByProgrammer(@PathVariable("id") Long id){
//        return repository.findTasksByProgrammerId(id);
//    }
//
//    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
//    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
//    public void addTaskToProgrammer(@PathVariable("programmerId") Long programmerID, @PathVariable("taskId") Long taskId){
//        repository.addTaskToProgrammer(programmerID,taskId);
//    }
//
//}
}