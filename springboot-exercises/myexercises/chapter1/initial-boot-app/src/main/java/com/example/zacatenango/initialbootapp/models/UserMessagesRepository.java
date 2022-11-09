package com.example.zacatenango.initialbootapp.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository public interface UserMessagesRepository extends CrudRepository<UserMessages, Long> {}
