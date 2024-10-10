package com.IOE.cs.city_sync.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping({"/","/home"})
    @ResponseBody
    public String generalwelcome(){
        return "Welcome to CitySync";
    }
}
