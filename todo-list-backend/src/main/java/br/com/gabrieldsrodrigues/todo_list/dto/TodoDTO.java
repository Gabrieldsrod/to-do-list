package br.com.gabrieldsrodrigues.todo_list.dto;

import br.com.gabrieldsrodrigues.todo_list.domain.entity.TodoEntity;
import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoPriority;
import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoStatus;
import org.springframework.beans.BeanUtils;

public class TodoDTO {

    private Long id;
    private String title;
    private String description;
    private TodoStatus status;
    private TodoPriority priority;

    public TodoDTO() {
    }

    public TodoDTO(TodoEntity todo) {
        BeanUtils.copyProperties(todo, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public TodoPriority getPriority() {
        return priority;
    }

}
