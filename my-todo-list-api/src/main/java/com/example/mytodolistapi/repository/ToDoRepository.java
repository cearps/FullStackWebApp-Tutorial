package com.example.mytodolistapi.repository;

import com.example.mytodolistapi.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
