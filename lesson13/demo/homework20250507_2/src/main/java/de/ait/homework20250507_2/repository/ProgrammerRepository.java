package de.ait.homework20250507_2.repository;

import de.ait.homework20250507_2.model.Programmer;
import de.ait.homework20250507_2.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProgrammerRepository {


    public List<Programmer> findAllProgrammers();

    public Programmer findProgrammerById(Long idProgrammer);

    public Programmer saveProgrammer(Programmer programmer);

    public Programmer addTaskToProgrammer(Long idProgrammer, Long idTask);

    public Programmer deleteTaskToProgrammer(Long idProgrammer, Long idTask);

    public Map<Long, String> findTaskById(Long idProgrammer);
}