package de.ait.homework20250514_1.service;

import de.ait.homework20250514_1.dto.TaskRequestDto;
import de.ait.homework20250514_1.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto createTask(TaskRequestDto dto);
    TaskResponseDto deleteTask(Long id);
}

