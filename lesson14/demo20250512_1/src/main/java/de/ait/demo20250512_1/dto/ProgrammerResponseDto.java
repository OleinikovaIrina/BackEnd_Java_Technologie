package de.ait.demo20250512_1.dto;

import de.ait.demo20250512_1.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProgrammerResponseDto {

    private Long id;
    private String name;


//    public ProgrammerResponseDto(Long id, String name) {
//        this.id = id;
//        this.name = name;
//        this.tasks = new HashSet<>();
//    }

//    public void addTask(Task task){
//        tasks.add(task);
//    }
//    public void removeTask(Task task){
//        tasks.remove(task);
//    }

}
