package de.ait.demo20250514_2.mappers;

import de.ait.demo20250514_2.dto.TaskRequestDto;
import de.ait.demo20250514_2.dto.TaskResponseDto;
import de.ait.demo20250514_2.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class})
public interface TaskMapper {

    TaskResponseDto toResponseDto(Task task);
    List<TaskResponseDto> toResponseDtoList(List<Task> task);
    Task fromRequestDto(TaskRequestDto dto);
}