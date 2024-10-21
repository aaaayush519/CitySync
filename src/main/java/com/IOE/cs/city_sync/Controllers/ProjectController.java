package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.DTOs.ProjResDTO;
import com.IOE.cs.city_sync.DTOs.ProjectListDTO;
import com.IOE.cs.city_sync.Services.DepartmentService;
import com.IOE.cs.city_sync.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/upload")
    public String uploadProject(Model model) {
        ProjResDTO projResDTO = new ProjResDTO();
        List<DepartmentListDTO> departmentListDTOS = departmentService.getAllDepartments();
        model.addAttribute("projResDTO", projResDTO);
        model.addAttribute("departments", departmentListDTOS);
        return "user/UploadProject";
    }

    @PostMapping("/submit")
    public String projectSubmission(@ModelAttribute ProjResDTO projectDTO, Principal user) {
        System.out.println(projectDTO.toString());
        projectService.saveProjectResource(projectDTO, user.getName());
        return "user/result";
    }

    @GetMapping("/showProjects")
    public String showProjects(Model model) {
        List<ProjectListDTO> allProjects = projectService.showProjects();
        model.addAttribute("allProjects", allProjects);
        return "user/showProjects";
    }

    @GetMapping("/myProjects")
    public String myProjects(Principal user, Model model) {
        List<ProjectListDTO> myProjects = projectService.myProjects(user.getName());
        model.addAttribute("myProjects", myProjects);
        return "user/showMyProjects";
    }
}
