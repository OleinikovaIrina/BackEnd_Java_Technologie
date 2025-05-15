package de.ait.homework20250514_1.mappers;


import de.ait.homework20250514_1.dto.ProgrammerResponseDto;
import de.ait.homework20250514_1.dto.TaskResponseDto;
import de.ait.homework20250514_1.model.Programmer;
import de.ait.homework20250514_1.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toResponsePrDto(Programmer programmer);
    List<ProgrammerResponseDto> toResponsePrDtoList(List<Programmer> programmers);
}
