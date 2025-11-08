package br.com.gabrieldsrodrigues.todo_list.service;

import br.com.gabrieldsrodrigues.todo_list.domain.entity.TodoEntity;
import br.com.gabrieldsrodrigues.todo_list.dto.TodoDTO;
import br.com.gabrieldsrodrigues.todo_list.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> create(TodoDTO todo) {
        TodoEntity todoEntity = new TodoEntity(todo);
        todoRepository.save(todoEntity);
        return list();
    }

    public List<TodoDTO> list() {
        List<TodoEntity> todos = todoRepository.findAllAndSortByPriority();
        return todos.stream().map(TodoDTO::new).toList();
    }

    public List<TodoDTO> update(TodoDTO todo) {
        TodoEntity todoEntity = new TodoEntity(todo);
        todoRepository.save(todoEntity);
        return list();
    }

    public List<TodoDTO> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
