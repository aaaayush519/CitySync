package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.CSUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTO {

    private Integer messageId;

    private Boolean response;

    private String username;

    private String projName;

    private String projLocation;

    private String projDescription ;

    private String projDepartment;

    public MessageDTO(Integer messageId, String projName, String projDepartment, String projDescription, String projLocation) {
        this.messageId = messageId;
        this.projName = projName;
        this.projDepartment = projDepartment;
        this.projDescription = projDescription;
        this.projLocation = projLocation;
    }
     public MessageDTO(Integer messageId, String projName, String projDepartment, String projDescription, String projLocation
             , String username , Boolean response) {
        this.username = username;
        this.response = response;
        this.messageId = messageId;
        this.projName = projName;
        this.projDepartment = projDepartment;
        this.projDescription = projDescription;
        this.projLocation = projLocation;
    }


}
