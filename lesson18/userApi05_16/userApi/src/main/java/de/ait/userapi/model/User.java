package de.ait.userapi.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@Setter
@Entity
@Table(name = "t_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(name = "user_name")
    private String name;
    private String email;
    private String password;
    @Embedded
    private Address address;
}
