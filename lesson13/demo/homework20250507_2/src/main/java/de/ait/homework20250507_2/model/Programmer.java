package de.ait.homework20250507_2.model;

import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Programmer {

    Long idProgrammer;
    String firstName;
    String lastName;
    String role;
    Map<Long, String> tasksById = new HashMap<>();
}