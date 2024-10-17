package com.IOE.cs.city_sync.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class ProjectListDTO {

    private String projectName;

    private String departmentName;

    private String location;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    public ProjectListDTO(String projectName, String departmentName, String location, String description, LocalDate startDate, LocalDate endDate) {
        this.projectName = projectName;
        this.departmentName = departmentName;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
