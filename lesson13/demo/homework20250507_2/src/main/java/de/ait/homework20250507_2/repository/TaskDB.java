package de.ait.homework20250507_2.repository;

import de.ait.homework20250507_2.model.Priority;
import de.ait.homework20250507_2.model.Task;
import de.ait.homework20250507_2.repository.TaskRepository;
import de.ait.homework20250507_2.model.Task;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TaskDB implements TaskRepository {

    private static HashMap<Long, Task> map = new HashMap<>();

    static{
        map.put(1L, new Task(1L, "Fix critical bug", Priority.HIGH));
        map.put(2L, new Task(2L, "Write unit tests", Priority.MEDIUM));
        map.put(3L, new Task(3L, "Update documentation", Priority.LOW));
        map.put(4L, new Task(4L, "Refactor legacy code", Priority.MEDIUM));
        map.put(5L, new Task(5L, "Deploy to production", Priority.HIGH));
    }

    public List<Task> findAll(){
        return map.values().stream().toList();
    }

    public Task findById(Long idTask){
        return map.get(idTask);
    }
    public Task save(Task task){
        map.put(task.getIdTask(), task);
        return task;
    }
    public List<Task> deleteById(Long idTask){
        map.remove(idTask);
        return map.values().stream().toList();
    }

}

