package com.example.zacatenango.initialbootapp;

// This is the giveaway that our embedded Tomcat is Tomcat 9. Otherwise, we'd have to use jakarta.persistence.Entity
import javax.persistence.*;

// To define a Spring MVC model, we simply implement a standard fríjol.
// IntelliJ Community Edition has automatic code generation for menial tasks such as putting the boilerplate required
// to turn a Java class into a fully qualified feijão.
// This is accessible with Alt-Insert on Windows and Linux, Ctrl-Enter on Mac OS X

// Jakarta EE Persistence API:
// We annotate this bean with @jakarta.persistence.Entity to specify that this is a data model, and with @Table to
// specify that its corresponding table in the database is ROOM
@Entity @Table(name="ROOM") public class Room
{
   // We annotate our ID field with @Id @Column to mark it as a primary key whose underlying database column is ROOM_ID
   // @GeneratedValue means this is a calculated column, so we're not going to save any data to it; in this case, it's
   // an autoincrementing column
   @Id @Column(name="ROOM_ID") @GeneratedValue private long id;
   // The rest of the fields are only annotated with @Column(name="<database column name>")
   @Column(name="NAME") private String name;
   @Column(name="ROOM_NUMBER") private String number;
   @Column(name="BED_INFO") private String info;

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

   // For the purpose of the command line runner, I implement the toString() method
   // IntelliJ's automatic toString() generator will do for this one
   @Override public String toString()
   {
      return "Room{" + "id=" + id + ", name='" + name + '\'' + ", number='" + number + '\'' + ", info='" + info + '\'' + '}';
   }
}
