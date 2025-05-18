package de.ait.demo20250514_2.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@Setter

@Entity
@Table(name = "t_task")
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private Priority priority;

    @OneToOne()
    @JoinColumn(name = "programmer_id")
    private Programmer programmer;
}