package com.IOE.cs.city_sync.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class DepartmentListDTO {

    private String name;

    private String description;

    private Long phoneNumber;

    public DepartmentListDTO(String name, String description, Long phoneNumber) {
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
