package de.ait.demo20250514_2.repository;

import de.ait.demo20250514_2.model.Priority;
import de.ait.demo20250514_2.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
@AllArgsConstructor
public class TaskRepositoryMapImpl implements TaskRepository{
    private static HashMap<Long, Task> map = new HashMap<>();
    private static Long lastId =5L;
    static {
        map.put(1L, new Task(1L,"Task 1", Priority.LOW));
        map.put(2L, new Task(2L,"Task 2", Priority.HIGH));
        map.put(3L, new Task(3L,"Task 3", Priority.LOW));
        map.put(4L, new Task(4L,"Task 4", Priority.MIDDLE));
        map.put(5L, new Task(5L,"Task 5", Priority.LOW));
    }


    @Override
    public List<Task> findAll() {
        return map.values().stream().toList();
    }

    @Override
    // return или значение Task или null
    public Task findById(Long id) {
        return map.get(id);
    }

    @Override
    public Task delete(Long id) {
        return map.remove(id);
    }

    @Override
    public Task save(Task task) {
        task.setId(++lastId);
        map.put(lastId, task);
        return task;
    }



}


