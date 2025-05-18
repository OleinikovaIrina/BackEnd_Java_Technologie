package de.ait.demo20250514_2.mappers;

import de.ait.demo20250514_2.dto.ProgrammerRequestDto;
import de.ait.demo20250514_2.dto.ProgrammerResponseDto;
import de.ait.demo20250514_2.dto.TaskRequestDto;
import de.ait.demo20250514_2.dto.TaskResponseDto;
import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toResponseDto(Programmer task);
    List<ProgrammerResponseDto> toResponseDtoList(List<Programmer> programmer);
    Programmer fromRequestDto(ProgrammerRequestDto dto);
}