package de.ait.homework20250514_1.service;

import de.ait.homework20250514_1.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {

    List<ProgrammerResponseDto> getAllProgrammers();

    ProgrammerResponseDto getProgrammerById(Long id);
}
