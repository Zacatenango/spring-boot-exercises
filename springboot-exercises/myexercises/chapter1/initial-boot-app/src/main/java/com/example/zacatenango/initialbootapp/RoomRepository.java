package com.example.zacatenango.initialbootapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Jakarta EE Persistence API:
// We create a repository interface tagged with @Repository that inherits from
// CrudRepository<<data type of the objects stored in it>, <data type of the ID column, if it's primitive it must be an encapsulating class>>
@Repository public interface RoomRepository extends CrudRepository<Room, Long> {}
