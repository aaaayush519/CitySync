package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Entities.Meetings;
import com.IOE.cs.city_sync.Repos.MeetingRepo;
import com.IOE.cs.city_sync.Repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepo meetingRepo;

    @Autowired
    private ProjectRepo projectRepo;

    public void addMeeting(MeetingsDTO meetingsDTO){
        Meetings meetings = new Meetings();
        meetings.setLocation(meetingsDTO.getLocation());
        meetings.setAgenda(meetingsDTO.getAgenda());
        meetings.setMeetingDate(meetingsDTO.getMeetingDate());
        meetings.setProject(projectRepo.getProjectById(meetingsDTO.getProjectId()));
        meetingRepo.save(meetings);
    }
}
