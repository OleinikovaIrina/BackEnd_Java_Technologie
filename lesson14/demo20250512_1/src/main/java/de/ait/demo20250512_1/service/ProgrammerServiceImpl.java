package de.ait.demo20250512_1.service;

import de.ait.demo20250512_1.dto.ProgrammerResponseDto;
import de.ait.demo20250512_1.model.Programmer;
import de.ait.demo20250512_1.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository repository;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
        return repository.findAll()
                .stream()
                .map(p -> new ProgrammerResponseDto(p.getId(), p.getName()))
                .toList();
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        Programmer programmer= repository.findById(id);
        if(programmer != null){
            return new ProgrammerResponseDto(programmer.getId(), programmer.getName());
        }else {
            throw new RuntimeException("Programmer not found");
        }
    }

}

