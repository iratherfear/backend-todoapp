package dev.iratherfear.reactbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.iratherfear.reactbackend.beans.Todo;
import dev.iratherfear.reactbackend.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class TodoController {
    
    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    @GetMapping("/users/{username}/todos")
    public List<Todo> retriveAllTodosForUsername(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }   

    @GetMapping("/users/{username}/todo/{id}")
    public Todo retriveTodoForUsername(@PathVariable String username, @PathVariable int id) {
        return todoRepository.findById(id).get();
    }   

    @PostMapping("/users/{username}/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodoForUsername(@PathVariable String username, @Valid @RequestBody Todo todo) {
        todo.setUsername(username);
        todoRepository.save(todo);
    }   

    @PutMapping("/users/{username}/todo/{id}")
    public void updateTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
    } 

    @DeleteMapping("/users/{username}/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }   
}
