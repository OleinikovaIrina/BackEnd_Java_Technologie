package de.ait.demo20250512_1.service;

import de.ait.demo20250512_1.dto.TaskRequestDto;
import de.ait.demo20250512_1.dto.TaskResponseDto;
import de.ait.demo20250512_1.model.Task;
import de.ait.demo20250512_1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        Task task = repository.findById(id);
        return mapToResponseDto(task);
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto dto) {
        Task task = new Task(null, dto.getDescription(), dto.getPriority());
        Task savedTask = repository.save(task);
        return mapToResponseDto(savedTask);
    }

    @Override
    public TaskResponseDto deleteTask(Long id) {
        Task deleted = repository.delete(id);
        return mapToResponseDto(deleted);
    }

    private TaskResponseDto mapToResponseDto(Task task) {
        return new TaskResponseDto(task.getId(), task.getDescription(), task.getPriority());
    }
}