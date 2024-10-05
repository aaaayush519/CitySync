package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.CSUserDTO;
import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Entities.Department;
import com.IOE.cs.city_sync.Repos.CSUserRepo;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CSUserService {

    @Autowired
    private CSUserRepo csUserRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public void addUser(CSUserDTO csUserDTO){
        CSUser csUser = new CSUser();
        csUser.setId(csUserDTO.getId());
        csUser.setEmail(csUserDTO.getEmail());
        csUser.setName(csUserDTO.getName());
        csUser.setPassword(csUserDTO.getPassword());
        csUser.setRole(csUserDTO.getRole());
        csUser.setDepartment(departmentRepo.getDepartmentById(csUserDTO.getDepartmentid()));
        csUserRepo.save(csUser);
        System.out.println(csUser.toString());
        System.out.println("Hello");
    }

}
