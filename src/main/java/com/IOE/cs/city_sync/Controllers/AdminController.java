package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.CSUserDTO;
import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.DTOs.UserListDTO;
import com.IOE.cs.city_sync.Services.CSUserService;
import com.IOE.cs.city_sync.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CSUserService csUserService;



    @GetMapping("")
    public String adminPage(){
        return "admin-rights";
    }
    @GetMapping({"/register-user"})
    public String registerUser(Model model){
        CSUserDTO csuserDto = new CSUserDTO();
        model.addAttribute("csuserDto", csuserDto);
        return "register";
    }

    @PostMapping("/add-user")
    public String userSubmission(CSUserDTO csuserdto , Model model){
        csUserService.addUser(csuserdto);
        model.addAttribute("message","Signup successful for "+ csuserdto.getName());
        return "result";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model){
        List<UserListDTO> allUsers = csUserService.getAllUsers();
        model.addAttribute("users",allUsers);
        return "showUsers";
    }



}
