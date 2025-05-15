package de.ait.demo20250514_2.service;


import de.ait.demo20250514_2.dto.TaskRequestDto;
import de.ait.demo20250514_2.dto.TaskResponseDto;
import de.ait.demo20250514_2.mappers.TaskMapper;
import de.ait.demo20250514_2.model.Task;
import de.ait.demo20250514_2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    private final TaskMapper mapper;



    @Override
    // return или значение TaskResponseDto или null
    public List<TaskResponseDto> getAllTasks() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return mapper.toResponseDto(repository.findById(id));
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) {
        Task task = mapper.fromRequestDto(taskDto);
        Task savedTask = repository.save(task);
        return mapper.toResponseDto(savedTask);
    }

    @Override
    public TaskResponseDto deleteTask(Long id) {
        return mapper.toResponseDto(repository.delete(id));
    }

}
