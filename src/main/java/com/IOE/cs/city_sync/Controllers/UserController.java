package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DepartmentServices departmentServices;

    @GetMapping("")
    public String userPage(){
        return "user-rights";
    }
    @GetMapping("/showDepartments")
    public String showDepartments(Model model){
        List<DepartmentListDTO> departments = departmentServices.getAllDepartments();
        model.addAttribute("department", departments);
        return "showDepartments";
    }
    // Upload Projecct
    // Upload Meetings
}
