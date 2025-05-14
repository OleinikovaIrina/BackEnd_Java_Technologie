package de.ait.homework20250514_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
