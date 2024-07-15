package com.crio.in.CoderHack.CoderHack.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_details")
public class User {

    @Column(name="id")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="user_name", columnDefinition = "varchar(30)")
    private String userName;

    @Column(name="score")
    private int score;

    @Column(name="badges", columnDefinition = "varchar(50)")
    private String badges;

}
