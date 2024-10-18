package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.Repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<MessageDTO> showMyMessages(String username){
        return messageRepo.getUserMessages(username);
    }

    public void updateResponse(Integer messageId, String name) {
        messageRepo.updateResponse(messageId,name);
    }

    public List<MessageDTO> getAllMessages() {
        List<MessageDTO> allMessages = messageRepo.getAllMessages();
        return allMessages;
    }
}
