package de.ait.demo20250514_2.dto;


import de.ait.demo20250514_2.model.Priority;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
public class TaskResponseDto {
    private Long id;
    private String description;
    private Priority priority;
}