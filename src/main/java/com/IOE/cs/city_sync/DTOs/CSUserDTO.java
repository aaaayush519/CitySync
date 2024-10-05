package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.Department;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CSUserDTO {

    private Integer id;

    private String name;

    private Integer departmentid;

    private String email;

    private String role;

    private String password;
}
