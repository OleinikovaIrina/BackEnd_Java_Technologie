package de.ait.homework20250507_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Task {

    Long id;
    String description ;
    Priority priority;
}
