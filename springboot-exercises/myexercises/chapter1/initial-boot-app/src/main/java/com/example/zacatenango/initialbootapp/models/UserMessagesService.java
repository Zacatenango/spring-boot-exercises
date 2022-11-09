package com.example.zacatenango.initialbootapp.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service public class UserMessagesService
{
   private UserMessagesRepository userMessagesRepository;
   @Autowired public UserMessagesService(UserMessagesRepository userMessagesRepository)
   {
      super();
      this.userMessagesRepository = userMessagesRepository;
   }

   public List<UserMessages> getAllUserMessages()
   {
      List<UserMessages> usermessages = new ArrayList<>();
      this.userMessagesRepository.findAll().forEach(usermessages::add);
      return usermessages;
   }
}
