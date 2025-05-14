package de.ait.demo20250512_1.model;


import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")

public class Task {
    @Setter
    private Long id;
    private String description;
    private Priority priority;
}
