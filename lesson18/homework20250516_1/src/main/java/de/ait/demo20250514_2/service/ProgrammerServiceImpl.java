package de.ait.demo20250514_2.service;

import de.ait.demo20250514_2.dto.ProgrammerRequestDto;
import de.ait.demo20250514_2.dto.ProgrammerResponseDto;
import de.ait.demo20250514_2.mappers.ProgrammerMapper;
import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammer() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        Programmer programmer = repository.findById(id).get();
        if (programmer != null) {
            return mapper.toResponseDto(programmer);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public ProgrammerResponseDto addProgrammer(ProgrammerRequestDto dto) {
        Programmer programmer = mapper.fromRequestDto(dto);
        Programmer savedProgrammer = repository.save(programmer);
        if (savedProgrammer != null) {
            return mapper.toResponseDto(savedProgrammer);
        } else {
            throw new RuntimeException("Error create new programmer");
        }
    }
}