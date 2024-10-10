package com.IOE.cs.city_sync.Controllers;


import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MeetingController {

    @Autowired
    MeetingService meetingService;
    @GetMapping("/upload-meeting")
    public String scheduleMeeting(Model model){
        MeetingsDTO meetingsDTO = new MeetingsDTO();
        model.addAttribute(meetingsDTO);
        return "meeting";
    }

    @PostMapping("/meeting-submit")
    public void saveMeeting(@ModelAttribute MeetingsDTO meetingsDTO){
        meetingService.addMeeting(meetingsDTO);
        System.out.println(meetingsDTO.toString());
    }
}
