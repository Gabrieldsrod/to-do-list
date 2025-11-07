package br.com.gabrieldsrodrigues.todo_list.domain.entity;

import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoPriority;
import br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @Enumerated(EnumType.STRING)
    private TodoPriority priority;

    @Column(name = "priority_weight")
    private int priorityWeight;

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
