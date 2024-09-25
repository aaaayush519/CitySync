package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.entities.CSUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<CSUsers, Integer> {
    CSUsers findByUsername(String username);
}
