package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Entities.Department;
import com.IOE.cs.city_sync.Entities.Meetings;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import com.IOE.cs.city_sync.Repos.MeetingRepo;
import com.IOE.cs.city_sync.Repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepo meetingRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public void addMeeting(MeetingsDTO meetingsDTO) {
        Meetings meetings = new Meetings();
        meetings.setLocation(meetingsDTO.getLocation());
        meetings.setAgenda(meetingsDTO.getAgenda());
        meetings.setMeetingDate(meetingsDTO.getMeetingDate());
        meetings.setProject(projectRepo.getProjectById(meetingsDTO.getProjectId()));

        List<Department> participatingDepartments = new ArrayList<>();
        for (Integer participatingDeptId : meetingsDTO.getParticipatingDeptId()) {
            participatingDepartments.add(departmentRepo.getDepartmentById(participatingDeptId));
        }
        meetings.setParticipatingDepartment(participatingDepartments);

        System.out.println(meetings.toString());
        meetingRepo.save(meetings);
    }
}
