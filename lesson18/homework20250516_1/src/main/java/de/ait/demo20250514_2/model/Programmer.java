package de.ait.demo20250514_2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table( name = "t_programmer")

public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @OneToOne(mappedBy = "programmer")
 private Task task;


}
