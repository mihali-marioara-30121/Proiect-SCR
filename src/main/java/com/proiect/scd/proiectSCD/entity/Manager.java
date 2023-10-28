package com.proiect.scd.proiectSCD.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    @JsonIgnoreProperties("managers")
    private Departament departament;

    @JsonIgnoreProperties("manager") // Add this line to ignore cyclic reference
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
}

