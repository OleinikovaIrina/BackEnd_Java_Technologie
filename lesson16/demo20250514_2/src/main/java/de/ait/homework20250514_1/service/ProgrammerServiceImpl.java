package de.ait.homework20250514_1.service;

import de.ait.homework20250514_1.dto.ProgrammerResponseDto;
import de.ait.homework20250514_1.mappers.ProgrammerMapper;
import de.ait.homework20250514_1.model.Programmer;
import de.ait.homework20250514_1.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository repository;
private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
        return mapper.toResponsePrDtoList(repository.findAll());
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

