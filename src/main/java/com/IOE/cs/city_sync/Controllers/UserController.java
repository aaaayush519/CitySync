package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.CSUserDTO;
import com.IOE.cs.city_sync.Services.CSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private CSUserService csUserService;

    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "Welcome to CitySync";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminfunction(){
        return "Hello ADMIN ! Welcome to CitySync";
    }

    @GetMapping("/user")
    @ResponseBody
    public String userfunction(){
        return "Hello USER ! Welcome to CitySync";
    }


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
}
