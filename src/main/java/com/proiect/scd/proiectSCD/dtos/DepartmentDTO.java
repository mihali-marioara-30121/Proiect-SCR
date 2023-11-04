package com.proiect.scd.proiectSCD.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private String description;

}