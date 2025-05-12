package de.ait.homework20250507_2.repository;

import de.ait.homework20250507_2.model.Task;
import de.ait.homework20250507_2.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository {

    public List<Task> findAll();
    public Task findById(Long idTask);
    public Task save(Task task);
    public List<Task>  deleteById(Long idTask);
}
