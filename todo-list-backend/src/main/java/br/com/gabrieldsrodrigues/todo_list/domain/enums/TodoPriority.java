package br.com.gabrieldsrodrigues.todo_list.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TodoPriority {

    HIGH(3, "High"),
    MEDIUM(2, "Medium"),
    LOW(1, "Low");

    private final int weight;
    private final String value;

    TodoPriority(int weight, String value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TodoPriority fromValue(String value) {

        if ("High".equals(value)) {
            return HIGH;
        } else if ("Medium".equals(value)) {
            return MEDIUM;
        } else if ("Low".equals(value)) {
            return LOW;
        } else {
            return null;
        }
    }
}