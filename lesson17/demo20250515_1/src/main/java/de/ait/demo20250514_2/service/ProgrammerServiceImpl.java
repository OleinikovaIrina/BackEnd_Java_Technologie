package de.ait.demo20250514_2.service;

import de.ait.demo20250514_2.dto.ProgrammerRequestDto;
import de.ait.demo20250514_2.dto.ProgrammerResponseDto;
import de.ait.demo20250514_2.mappers.ProgrammerMapper;
import de.ait.demo20250514_2.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammer() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return null;
    }

    @Override
    public ProgrammerResponseDto createTask(ProgrammerRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public ProgrammerResponseDto deleteTask(Long id) {
        return null;
    }
}