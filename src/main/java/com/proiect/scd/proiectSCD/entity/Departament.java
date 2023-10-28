package com.proiect.scd.proiectSCD.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "departaments")
public class Departament {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

//    @Column(name = "manager_id", nullable = false)
//    private Long manager_id;

    @JsonIgnoreProperties("departament") // Add this line to ignore cyclic reference
    @OneToMany(mappedBy = "departament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Manager> managers;
    @JsonIgnoreProperties("departament") // Add this line to ignore cyclic reference
    @OneToMany(mappedBy = "departament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Employee> employees;
}
