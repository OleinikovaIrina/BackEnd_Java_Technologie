package de.ait.demo20250514_2.controller;

import de.ait.demo20250514_2.dto.ProgrammerRequestDto;
import de.ait.demo20250514_2.dto.ProgrammerResponseDto;
import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.model.Task;
import de.ait.demo20250514_2.repository.ProgrammerRepository;
import de.ait.demo20250514_2.service.ProgrammerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")
public class ProgrammerController {

    private final ProgrammerService service;


    @GetMapping
    public ResponseEntity<List<ProgrammerResponseDto>>getProgrammers(){
        return ResponseEntity.ok().body(service.getAllProgrammer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammerResponseDto> getProgrammerById(@PathVariable("id") Long id){
        return ResponseEntity.ofNullable(service.getProgrammerById(id));
    }


    @PostMapping

    public ResponseEntity<ProgrammerResponseDto>addProgrammer(@RequestBody ProgrammerRequestDto dto){
        ProgrammerResponseDto saved = service.addProgrammer(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

}
