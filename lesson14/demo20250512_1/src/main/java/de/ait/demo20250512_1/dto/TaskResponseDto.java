package de.ait.demo20250512_1.dto;

import de.ait.demo20250512_1.model.Priority;
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
