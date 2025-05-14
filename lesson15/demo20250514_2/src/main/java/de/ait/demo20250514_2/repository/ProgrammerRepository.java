package de.ait.demo20250514_2.repository;

import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.model.Task;

import java.util.List;

public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}