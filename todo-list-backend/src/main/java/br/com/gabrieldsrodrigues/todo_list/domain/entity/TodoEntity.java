package br.com.gabrieldsrodrigues.todo_list.domain.entity;

import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoPriority;
import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoStatus;
import br.com.gabrieldsrodrigues.todo_list.dto.TodoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoPriority priority;

    public TodoEntity() {
    }

    public TodoEntity(String title, String description, TodoStatus status, TodoPriority priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public TodoEntity(TodoDTO todo) {
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

    public void setPriority(TodoPriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TodoEntity that = (TodoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
