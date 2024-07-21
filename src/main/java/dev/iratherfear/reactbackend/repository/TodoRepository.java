package dev.iratherfear.reactbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.iratherfear.reactbackend.beans.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUsername(String username);
}
