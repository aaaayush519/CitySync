package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.ProjResDTO;
import com.IOE.cs.city_sync.DTOs.ResourceDTO;
import com.IOE.cs.city_sync.Entities.Project;
import com.IOE.cs.city_sync.Entities.Resource;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import com.IOE.cs.city_sync.Repos.ProjectRepo;
import com.IOE.cs.city_sync.Repos.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProjResService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private DepartmentRepo departmentrepo;

    public void saveProjectResource(ProjResDTO projResDTO) {
        Project project = new Project();
        project.setName(projResDTO.getProjectName());
        project.setDepartment(departmentrepo.getDepartmentById(projResDTO.getDepartmentid()));
        project.setDescription(projResDTO.getProjDescription());
        project.setStartDate(projResDTO.getStartDate());
        project.setEndDate(projResDTO.getEndDate());
        project.setUploadDate(LocalDate.now());
        project.setIsInterdepartmental(false);
        project.setLocation(projResDTO.getLocation());
        projectRepo.save(project);

        // Resource

        for (ResourceDTO resourceDTO : projResDTO.getResources()) {
            System.out.println(resourceDTO.toString());
            Resource resource = new Resource();
            resource.setProject(projectRepo.getById(project.getId()));
            resource.setName(resourceDTO.getResourceName());
            resource.setQuantity(resourceDTO.getQuantity());
            resource.setDescription(resourceDTO.getResDescription());
            resource.setIsAvailable(true);
            System.out.println(resource.toString());
            resourceRepo.save(resource);
        }

    }
}


//        Resource resource = new Resource();
//        resource.setProject(project);
//        resource.setName(projResDTO.getResourceName());
//        resource.setIsAvailable(true);
//        resource.setQuantity(projResDTO.getQuantity());
//        resource.setDescription(projResDTO.getResDescription());
//        resourceRepo.save(resource);
