package br.com.gabrieldsrodrigues.todo_list.repository;

import br.com.gabrieldsrodrigues.todo_list.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("SELECT t FROM Todo t ORDER BY " +
            "CASE t.priority " +
            "  WHEN 'HIGH' THEN 3 " +
            "  WHEN 'MEDIUM' THEN 2 " +
            "  WHEN 'LOW' THEN 1 " +
            "  ELSE 0 " +
            "END DESC")
    List<Todo> findAllAndSortByPriority();
}
