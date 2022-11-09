package com.example.zacatenango.initialbootapp.models;

import javax.persistence.*;

@Entity @Table(name="usermessages", schema="public") public class UserMessages
{
   @Id @Column(name="MESSAGE_ID") @GeneratedValue private long id;
   @Column(name="USER_ID") private long userID;
   @Column(name="MESSAGE") private String message;

   public UserMessages() { super(); }

   public UserMessages(long id, long userID, String message)
   {
      super();
      this.id = id;
      this.userID = userID;
      this.message = message;
   }

   public long getId() { return id; }
   public void setId(long id) { this.id = id; }

   public long getUserID() { return userID; }
   public void setUserID(long userID) { this.userID = userID; }

   public String getMessage() { return message; }
   public void setMessage(String message) { this.message = message; }
}
