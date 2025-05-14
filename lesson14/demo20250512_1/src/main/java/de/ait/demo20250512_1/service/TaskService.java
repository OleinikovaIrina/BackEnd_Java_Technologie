package de.ait.demo20250512_1.service;

import de.ait.demo20250512_1.dto.TaskRequestDto;
import de.ait.demo20250512_1.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto createTask(TaskRequestDto dto);
    TaskResponseDto deleteTask(Long id);
}

