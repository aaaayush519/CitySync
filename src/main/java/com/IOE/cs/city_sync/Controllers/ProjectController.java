package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.ProjectDTO;
import com.IOE.cs.city_sync.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @GetMapping("/upload-project")
    public String uploadProject(Model model){
        ProjectDTO projectDTO = new ProjectDTO();
        model.addAttribute("projectDTO", projectDTO);
        return "UploadProject";
    }

    @PostMapping("/project-submit")
    public String projectSubmission( ProjectDTO projectDTO , Model model){
        System.out.println(projectDTO.getUploadDate());
        projectService.saveProject(projectDTO);
        model.addAttribute("message","Uploaded Project "+ projectDTO.getName());
        return "result";
    }
}
