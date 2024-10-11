package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.ProjResDTO;
import com.IOE.cs.city_sync.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/upload")
    public String uploadProject(Model model) {
        ProjResDTO projResDTO = new ProjResDTO();
        model.addAttribute("projResDTO", projResDTO);
        return "UploadProject";
    }

    @PostMapping("/submit")
    public String projectSubmission(@ModelAttribute ProjResDTO projectDTO) {
        System.out.println(projectDTO.toString());
        projectService.saveProjectResource(projectDTO);
        return "result";
    }
}
