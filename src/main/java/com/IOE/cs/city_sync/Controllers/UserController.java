package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.DTOs.ProjectListDTO;
import com.IOE.cs.city_sync.Services.DepartmentService;
import com.IOE.cs.city_sync.Services.MessageService;
import com.IOE.cs.city_sync.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public String userPage(){
        return "user-rights";
    }
    @GetMapping("/showDepartments")
    public String showDepartments(Model model){
        List<DepartmentListDTO> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "showDepartments";
    }

    @GetMapping("/showMyMessages")
    public String showMyMessages(Principal user , Model model){
        List<MessageDTO> myMessages = messageService.showMyMessages(user.getName());
        System.out.println(user.getName());
        model.addAttribute("allMessages" , myMessages);
        return "showMessages";
    }

    @PostMapping("/update-Response")
    public String updateResponse(@RequestParam("messageId")Integer messageId,Principal user){
        messageService.updateResponse(messageId , user.getName());
        return "redirect:/user/showMyMessages";
    }

}
