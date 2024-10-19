package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.Repos.CSUserRepo;
import com.IOE.cs.city_sync.Repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private CSUserRepo csUserRepo;

    public List<MessageDTO> showMyMessages(String username){
        Integer deptId = csUserRepo.getDepartmentIdByUsername(username);
        return messageRepo.getUserMessages(username,deptId);
    }

    public List<MessageDTO> showApprovedMessages(String username){
        Integer deptId = csUserRepo.getDepartmentIdByUsername(username);
        return messageRepo.getApprovedMessages(username , deptId);
    }

    public void updateResponse(Integer messageId, String name) {
        messageRepo.updateResponse(messageId,name);
    }

    public List<MessageDTO> getAllMessages() {
        List<MessageDTO> allMessages = messageRepo.getAllMessages();
        return allMessages;
    }
}
