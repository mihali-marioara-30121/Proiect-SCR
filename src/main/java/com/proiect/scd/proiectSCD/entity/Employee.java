package com.proiect.scd.proiectSCD.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table (name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    @JsonIgnoreProperties("employees") // Add this line to ignore cyclic references
    private Departament departament;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonIgnoreProperties("employees") // Add this line to ignore cyclic references
    private Manager manager;

}
