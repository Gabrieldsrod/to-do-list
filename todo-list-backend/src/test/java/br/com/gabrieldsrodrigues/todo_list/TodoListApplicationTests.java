package br.com.gabrieldsrodrigues.todo_list;

import br.com.gabrieldsrodrigues.todo_list.domain.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


import static br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoPriority.MEDIUM;
import static br.com.gabrieldsrodrigues.todo_list.domain.enums.TodoStatus.ONGOING;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo 1", "desc todo 1", ONGOING, MEDIUM);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].title").isEqualTo(todo.getTitle())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].status").isEqualTo(todo.getStatus().getStatus())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority().getValue());
	}

	@Test
	void testCreateTodoFail() {

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todo("", "", null, null)
				).exchange()
				.expectStatus().isBadRequest();

	}


}
