package com.IOE.cs.city_sync.Controllers;


import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/meetings")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/upload")
    public String scheduleMeeting(Model model) {
        MeetingsDTO meetingsDTO = new MeetingsDTO();
        model.addAttribute(meetingsDTO);
        return "user/meeting";
    }

    @PostMapping("/submit")
    public String saveMeeting(@ModelAttribute MeetingsDTO meetingsDTO, Model model) {
        meetingService.addMeeting(meetingsDTO);
        model.addAttribute("message", "added meeting" + meetingsDTO);
        return "user/result";
    }
}
