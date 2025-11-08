package br.com.gabrieldsrodrigues.todo_list.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TodoStatus {
    PENDING ("Pending"),
    ONGOING ("Ongoing"),
    FINISHED ("Finished"),
    CANCELLED ("Cancelled"),
    PAUSED ("Paused");

    private final String status;

    TodoStatus (String status){
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static TodoStatus fromValue(String value) {
        if ("Pending".equals(value)) {
            return PENDING;
        } else if ("Ongoing".equals(value)) {
            return ONGOING;
        } else if ("Finished".equals(value)) {
            return FINISHED;
        } else if ("Cancelled".equals(value)) {
            return CANCELLED;
        } else if ("Paused".equals(value)) {
            return PAUSED;
        } else {
            return null;
        }
    }
}
