package de.ait.homework20250507_2.model;

import de.ait.homework20250507_2.model.Priority;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter

public class Task {

    Long idTask;
    String description ;
    Priority priority;
}
