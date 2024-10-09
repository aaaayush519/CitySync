package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.ProjResDTO;
import com.IOE.cs.city_sync.DTOs.ResourceDTO;
import com.IOE.cs.city_sync.Services.ProjResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjResController {

    @Autowired
    private ProjResService projResService;

    @GetMapping("/upload-project")
    public String uploadProject(Model model) {
        ProjResDTO projResDTO = new ProjResDTO();
        model.addAttribute("projResDTO", projResDTO);
        return "UploadProjRes";
    }

    @PostMapping("/project-submit")
    public String projectSubmission(@ModelAttribute ProjResDTO projectDTO) {
        projResService.saveProjectResource(projectDTO);
        return "result";
    }
}
