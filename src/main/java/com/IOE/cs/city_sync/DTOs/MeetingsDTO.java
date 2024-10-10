package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Entities.Department;
import com.IOE.cs.city_sync.Entities.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingsDTO {


    private String location;

    private String agenda;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date meetingDate;

    private Integer projectId;

    private String addedBy;

    private List<Department> participatingDepartments;
}
