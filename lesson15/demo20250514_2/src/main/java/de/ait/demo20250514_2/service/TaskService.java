package de.ait.demo20250514_2.service;

import de.ait.demo20250514_2.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
}