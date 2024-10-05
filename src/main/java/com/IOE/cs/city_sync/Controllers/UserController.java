package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.CSUserDTO;
import com.IOE.cs.city_sync.Services.CSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private CSUserService csUserService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        CSUserDTO user = new CSUserDTO();
        model.addAttribute("csuserDto", user);
        return "register";
    }

    @PostMapping("/submit")
    public String submission(CSUserDTO csuserdto , Model model){
        csUserService.addUser(csuserdto);
        model.addAttribute("message","Signup successful for "+ csuserdto.getName());
        return "result";
    }
}
