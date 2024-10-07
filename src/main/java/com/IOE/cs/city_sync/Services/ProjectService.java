package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.ProjectDTO;
import com.IOE.cs.city_sync.Entities.Department;
import com.IOE.cs.city_sync.Entities.Project;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import com.IOE.cs.city_sync.Repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private DepartmentRepo departmentrepo;

    public void saveProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDepartment(departmentrepo.getDepartmentById(projectDTO.getDepartmentid()));
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setUploadDate(LocalDate.now());
        project.setIsInterdepartmental(false);
        project.setLocation(projectDTO.getLocation());
        projectRepo.save(project);
    }
}