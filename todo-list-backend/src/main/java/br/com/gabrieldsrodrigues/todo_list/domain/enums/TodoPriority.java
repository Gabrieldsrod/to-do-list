package br.com.gabrieldsrodrigues.todo_list.domain.enums;

public enum TodoPriority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int weight;

    TodoPriority(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
