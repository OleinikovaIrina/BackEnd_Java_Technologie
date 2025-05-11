package de.ait.homework20250507_1.repository;

import de.ait.homework20250507_1.model.Task;

import java.util.List;

public interface TaskRepository {

    public List<Task> findAll();
    public Task findById(Long id);
    public Task save(Task task);
    public List<Task>  deleteById(Long id);
}
