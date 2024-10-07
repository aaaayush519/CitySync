package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.CSUserDTO;
import com.IOE.cs.city_sync.DTOs.ProjectDTO;
import com.IOE.cs.city_sync.Services.CSUserService;
import com.IOE.cs.city_sync.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private CSUserService csUserService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        CSUserDTO csuserDto = new CSUserDTO();
        model.addAttribute("csuserDto", csuserDto);
        return "register";
    }

    @PostMapping("/user-submit")
    public String userSubmission(CSUserDTO csuserdto , Model model){
        csUserService.addUser(csuserdto);
        model.addAttribute("message","Signup successful for "+ csuserdto.getName());
        return "result";
    }

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
