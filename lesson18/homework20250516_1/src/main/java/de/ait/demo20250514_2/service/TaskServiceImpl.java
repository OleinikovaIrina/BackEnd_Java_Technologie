package de.ait.demo20250514_2.service;


import de.ait.demo20250514_2.dto.TaskRequestDto;
import de.ait.demo20250514_2.dto.TaskResponseDto;
import de.ait.demo20250514_2.mappers.TaskMapper;
import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.model.Task;
import de.ait.demo20250514_2.repository.ProgrammerRepository;
import de.ait.demo20250514_2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    private final TaskMapper mapper;
private  final ProgrammerRepository programmerRepository;


    @Override
    // return или значение TaskResponseDto или null
    public List<TaskResponseDto> getAllTasks() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {

        return mapper.toResponseDto(repository.findById(id).orElse(null));
    }


    @Override
    public TaskResponseDto saveTask(TaskRequestDto dto) {

        if (dto.getProgrammerId() == null) {
            throw new IllegalArgumentException("Programmer ID must not be null");
        }
        Programmer programmer= programmerRepository.findById(dto.getProgrammerId()).orElseThrow(()->new RuntimeException("Programmer not found"));

    Task task =mapper.fromRequestDto(dto);
    task.setProgrammer(programmer);

    Task saved = repository.save(task);
    return  mapper.toResponseDto(saved);
    }
}
