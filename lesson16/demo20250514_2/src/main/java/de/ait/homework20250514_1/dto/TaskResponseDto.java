package de.ait.homework20250514_1.dto;

import de.ait.homework20250514_1.model.Priority;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString



public class TaskResponseDto {

        private Long id;
        private String description;
        private Priority priority;
    }
