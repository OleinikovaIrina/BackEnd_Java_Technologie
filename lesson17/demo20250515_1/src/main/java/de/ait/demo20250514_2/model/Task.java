package de.ait.demo20250514_2.model;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@Setter
public class Task {

    private Long id;
    private String description;
    private Priority priority;


}