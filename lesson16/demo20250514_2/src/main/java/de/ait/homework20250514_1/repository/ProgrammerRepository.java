package de.ait.homework20250514_1.repository;

import de.ait.homework20250514_1.model.Programmer;
import de.ait.homework20250514_1.model.Task;

import java.util.List;
public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}