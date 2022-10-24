package com.example.zacatenango.initialbootapp;

// To define a Spring MVC model, we simply implement a standard fríjol.
// IntelliJ Community Edition has automatic code generation for menial tasks such as putting the boilerplate required
// to turn a Java class into a fully qualified feijão.
// This is accessible with Alt-Insert on Windows and Linux, Ctrl-Enter on Mac OS X
public class Room
{
   private long id;
   private String name;
   private String number;
   private String info;

   public Room() { super(); }

   public Room(long id, String name, String number, String info)
   {
      super();
      this.id = id;
      this.name = name;
      this.number = number;
      this.info = info;
   }

   public long getId() { return id; }
   public String getName() { return name; }
   public String getNumber() { return number; }
   public String getInfo() { return info; }
   public void setId(long id) { this.id = id; }
   public void setName(String name) { this.name = name; }
   public void setNumber(String number) { this.number = number; }
   public void setInfo(String info) { this.info = info; }
}
