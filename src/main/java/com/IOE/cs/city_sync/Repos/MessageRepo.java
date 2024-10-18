package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Integer> {

    @Query("SELECT new com.IOE.cs.city_sync.DTOs.MessageDTO(m.id ,p.name , d.name , p.Description , p.location)  FROM Message m LEFT JOIN Project p ON m.project.id = p.id " +
            "LEFT JOIN Department d ON p.department.id = d.id where m.recepientUser.username = :user AND m.response = false ")
    List<MessageDTO> getUserMessages(@Param("user") String user);

    @Query("SELECT new com.IOE.cs.city_sync.DTOs.MessageDTO(m.id ,p.name , d.name , p.Description , p.location, u.username , m.response)  FROM Message m LEFT JOIN Project p ON m.project.id = p.id " +
            "LEFT JOIN Department d ON p.department.id = d.id LEFT JOIN CSUser u on m.recepientUser.id = u.id ")
    List<MessageDTO> getAllMessages();

    @Modifying
    @Transactional
    @Query("UPDATE Message m SET m.response = true where m.recepientUser.username = :name AND m.id = :messageId")
    void updateResponse(@Param("messageId") Integer messageId, @Param("name") String name);
}
