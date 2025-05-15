package de.ait.homework20250514_1.mappers;

import de.ait.homework20250514_1.dto.TaskResponseDto;
import de.ait.homework20250514_1.model.Task;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toResponseDto(Task task);
    List<TaskResponseDto> toResponseDtoList(List<Task> task);
}
