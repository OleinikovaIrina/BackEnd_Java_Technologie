package de.ait.homework20250514_1.model;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")

public class Task {

    private Long id;
    private String description;
    private Priority priority;
}
