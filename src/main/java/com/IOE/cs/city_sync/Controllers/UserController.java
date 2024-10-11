package com.IOE.cs.city_sync.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String userPage(){
        return "user-rights";
    }

    // Upload Projecct
    // Upload Meetings
}
