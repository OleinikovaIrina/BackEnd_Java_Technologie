package de.ait.demo20250512_1.service;

import de.ait.demo20250512_1.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {

    List<ProgrammerResponseDto> getAllProgrammers();

    ProgrammerResponseDto getProgrammerById(Long id);
}
