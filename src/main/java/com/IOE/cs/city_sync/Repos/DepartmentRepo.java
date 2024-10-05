package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

    Department getDepartmentById(Integer id);
}
