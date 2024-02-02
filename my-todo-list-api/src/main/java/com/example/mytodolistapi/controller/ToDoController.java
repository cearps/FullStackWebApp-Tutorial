package com.example.mytodolistapi.controller;

import com.example.mytodolistapi.model.ToDo;
import com.example.mytodolistapi.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getToDos() {
        return toDoService.getToDos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ToDo addToDo(@Valid @RequestBody AddToDoRequest addToDoRequest) {
        return toDoService.addToDo(addToDoRequest.description());
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable long id) {
        toDoService.deleteToDo(id);
    }

    @PatchMapping("/{id}")
    public void updateToDo(@PathVariable long id, @RequestParam Boolean completed) {
        toDoService.updateTodo(id, completed);
    }
}
