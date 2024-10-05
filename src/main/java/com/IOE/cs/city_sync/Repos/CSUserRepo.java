package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.Entities.CSUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CSUserRepo extends JpaRepository<CSUser,Integer> {

    CSUser save(CSUser csUser);
}
