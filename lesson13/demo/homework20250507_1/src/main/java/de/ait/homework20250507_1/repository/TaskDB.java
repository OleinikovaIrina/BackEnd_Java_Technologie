package de.ait.homework20250507_1.repository;

import de.ait.homework20250507_1.model.Priority;
import de.ait.homework20250507_1.model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDB implements TaskRepository{

    private static HashMap<Long, Task> map = new HashMap<>();

    static{
        map.put(1L, new Task(1L, "Fix critical bug", Priority.HIGH));
        map.put(2L, new Task(2L, "Write unit tests", Priority.MEDIUM));
        map.put(3L, new Task(3L, "Update documentation", Priority.LOW));
    }

    public List<Task> findAll(){
        return map.values().stream().toList();
    }

    public Task findById(Long id){
        return map.get(id);
    }
    public Task save(Task task){
        map.put(task.getId(), task);
        return task;
    }
    public List<Task> deleteById(Long id){
        map.remove(id);
        return map.values().stream().toList();
    }

}

