package de.ait.homework20250507_2.repository;

import de.ait.homework20250507_2.model.Programmer;
import de.ait.homework20250507_2.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProgrammerDB implements ProgrammerRepository {

    private final TaskRepository taskRepository;

    @Autowired
    public ProgrammerDB(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private static HashMap<Long, Programmer> map = new HashMap<>();

    static {
        map.put(1L, new Programmer(1L, "Alice", "Smith", "Backend Developer", new HashMap<>()));
        map.put(2L, new Programmer(2L, "Bob", "Johnson", "Frontend Developer", new HashMap<>()));
        map.put(3L, new Programmer(3L, "Charlie", "Williams", "Fullstack Developer", new HashMap<>()));
        map.put(4L, new Programmer(4L, "Diana", "Brown", "QA Engineer", new HashMap<>()));
    }


    public List<Programmer> findAllProgrammers() {
        return map.values().stream().toList();
    }

    public Programmer findProgrammerById(Long idProgrammer) {
        return map.get(idProgrammer);
    }

    public Programmer saveProgrammer(Programmer programmer) {
        map.put(programmer.getIdProgrammer(), programmer);
        return programmer;
    }


    @Override
    public Programmer addTaskToProgrammer(Long idProgrammer, Long idTask) {
        Programmer programmer = map.get(idProgrammer);
        if (programmer == null) {
            throw new RuntimeException("Programmer with id " + idProgrammer + " not found.");
        }

        Task task = taskRepository.findById(idTask);

        programmer.getTasksById().put(idTask, task.getDescription());


        return programmer;
    }




    @Override
    public Programmer deleteTaskToProgrammer(Long idProgrammer, Long idTask) {
        Programmer programmer = map.get(idProgrammer);
        if (programmer == null) {
            throw new RuntimeException("Programmer with id " + idProgrammer + " not found.");
        }

        Task task = taskRepository.findById(idTask);

        programmer.getTasksById().remove(idTask);


        return programmer;
    }

    @Override
    public Map<Long, String> findTaskById(Long idProgrammer) {
        Programmer programmer = map.get(idProgrammer);
        if (programmer == null) {
            throw new RuntimeException("Programmer with id " + idProgrammer + " not found.");
        }

        return programmer.getTasksById();


    }
}
