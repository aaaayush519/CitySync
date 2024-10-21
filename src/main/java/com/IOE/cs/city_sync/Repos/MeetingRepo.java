package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.Entities.Meetings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepo extends JpaRepository<Meetings, Integer> {


}
