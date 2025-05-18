package de.ait.demo20250514_2.dto;


import de.ait.demo20250514_2.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class TaskRequestDto {
    private String description;
    private Priority priority;
    private Long programmerId;


}