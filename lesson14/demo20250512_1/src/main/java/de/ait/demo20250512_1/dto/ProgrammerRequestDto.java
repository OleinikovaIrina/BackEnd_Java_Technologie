package de.ait.demo20250512_1.dto;

import de.ait.demo20250512_1.model.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@Getter
public class ProgrammerRequestDto {

    private String name;


//    public ProgrammerRequestDto(Long id, String name) {
//        this.id = id;
//        this.name = name;
//        this.tasks = new HashSet<>();
//    }
//
//    public void addTask(Task task){
//        tasks.add(task);
//    }
//    public void removeTask(Task task){
//        tasks.remove(task);
//    }

}
