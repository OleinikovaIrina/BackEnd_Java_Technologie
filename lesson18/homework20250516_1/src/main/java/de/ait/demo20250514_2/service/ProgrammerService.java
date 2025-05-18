package de.ait.demo20250514_2.service;

import de.ait.demo20250514_2.dto.ProgrammerRequestDto;
import de.ait.demo20250514_2.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAllProgrammer();
    ProgrammerResponseDto getProgrammerById(Long id);
    ProgrammerResponseDto addProgrammer (ProgrammerRequestDto dto);

}