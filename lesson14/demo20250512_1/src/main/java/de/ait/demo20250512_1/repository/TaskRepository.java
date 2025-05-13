package de.ait.demo20250512_1.repository;

import de.ait.demo20250512_1.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task delete(Long id);
    Task save(Task task);


}