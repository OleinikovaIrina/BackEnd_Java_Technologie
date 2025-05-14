package de.ait.homework20250514_1.controller;

import de.ait.homework20250514_1.dto.ProgrammerResponseDto;

import de.ait.homework20250514_1.repository.ProgrammerRepository;
import de.ait.homework20250514_1.service.ProgrammerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequiredArgsConstructor
public class ProgrammerController {

    private final ProgrammerRepository repository;
    private final ProgrammerService service;


    @GetMapping("/programmers")
    public ResponseEntity<List<ProgrammerResponseDto> >getProgrammers() {
        List<ProgrammerResponseDto> allProgrammers = service.getAllProgrammers();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-ProgrammerOfSize", String.valueOf(allProgrammers.size()));
        return new ResponseEntity<>(allProgrammers, headers, HttpStatus.OK);
    }

    @GetMapping("/programmers/{id}")
    public ResponseEntity<ProgrammerResponseDto> getProgrammerById(@PathVariable("id") Long id) {
       try {
           return  ResponseEntity.ok(service.getProgrammerById(id));
       }catch (Exception e){
           return ResponseEntity.notFound().build();
       }
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