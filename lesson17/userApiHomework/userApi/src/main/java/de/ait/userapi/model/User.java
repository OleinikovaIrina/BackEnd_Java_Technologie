package de.ait.userapi.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@Setter

@Entity
@Table(name = "t-user")

public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String email;
    private String password;
}
