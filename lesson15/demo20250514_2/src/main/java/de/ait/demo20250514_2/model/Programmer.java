package de.ait.demo20250514_2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
public class Programmer {
    @Setter
    private Long id;
    private String name;
    private Set<Task> tasks;

    public Programmer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new HashSet<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }

}