package de.ait.homework20250514_1.repository;

import de.ait.homework20250514_1.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task delete(Long id);
    Task save(Task task);


}