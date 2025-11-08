package br.com.gabrieldsrodrigues.todo_list.dto;

import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoPriority;
import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoStatus;
import jakarta.persistence.*;

public class TodoDTO {

    private Long id;
    private String title;
    private String description;
    private TodoStatus status;
    private TodoPriority priority;
    private int priorityWeight;

    public TodoDTO() {
    }

    public TodoDTO(Long id, String title, String description, TodoStatus status, TodoPriority priority, int priorityWeight) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.priorityWeight = priorityWeight;
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

    public void setPriority(TodoPriority priority) {
        this.priority = priority;
        this.priorityWeight = priority.getWeight();
    }

    public int getPriorityWeight() {
        return priorityWeight;
    }
}
