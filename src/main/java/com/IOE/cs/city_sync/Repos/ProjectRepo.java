package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
    Project save(Project project);
}
