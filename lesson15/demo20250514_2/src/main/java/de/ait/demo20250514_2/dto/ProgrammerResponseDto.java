package de.ait.demo20250514_2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProgrammerResponseDto {
    private Long id;
    private String name;
    private Set<TaskResponseDto> tasks;
}