package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.Entities.Department;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServices {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<DepartmentListDTO> getAllDepartments(){
        return departmentRepo.getAllDepartments();
    }
}
