package de.ait.demo20250514_2.repository;

import de.ait.demo20250514_2.model.Programmer;
import de.ait.demo20250514_2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
    public List<Programmer> findAll();

    public Optional<Programmer> findById(Long id);

    public Programmer save(Programmer programmer);

    public Stream<Programmer> findByName(String name);
//    void addTaskToProgrammer(Long programmerId, Long taskId);
//    void deleteTaskToProgrammer(Long programmerId, Long taskId);
//    List<Task> findTasksByProgrammerId(Long id);

}