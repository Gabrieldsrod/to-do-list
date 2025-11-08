package br.com.gabrieldsrodrigues.todo_list.controller;

import br.com.gabrieldsrodrigues.todo_list.domain.entity.TodoEntity;
import br.com.gabrieldsrodrigues.todo_list.dto.TodoDTO;
import br.com.gabrieldsrodrigues.todo_list.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<TodoDTO> create(@RequestBody @Valid TodoDTO todo) {
        return todoService.create(todo);
    }

    @GetMapping
    List<TodoDTO> list() {
        return todoService.list();
    }

    @PutMapping
    List<TodoDTO> update(@RequestBody TodoDTO todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<TodoDTO> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
