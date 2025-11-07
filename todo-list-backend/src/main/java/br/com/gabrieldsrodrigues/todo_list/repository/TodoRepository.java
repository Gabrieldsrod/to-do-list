package br.com.gabrieldsrodrigues.todo_list.repository;

import br.com.gabrieldsrodrigues.todo_list.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
