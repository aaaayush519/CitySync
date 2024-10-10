package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
    Project save(Project project);

    @Override
    Project getById(Integer id);

    Project getProjectById(Integer projectId);
}
