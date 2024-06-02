package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoJpaResource {

	private final TodoService todoService;
	private final TodoRepository todoRepository;

	// 룸북 사용을 안할 때 사용하는 생성자 주입 방법
//	public TodoResource(TodoService todoService) {
//		this.todoService = todoService;
//	}

	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		return todoRepository.findByUsername(username);
	}

	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
		return  todoRepository.findById(id).get();
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {

		todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();// noContent()는 성공시 204웅답을 리턴함

	}

	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {

//		todoService.updateTodo(todo);
		todoRepository.save(todo);// insert와 update에 save는 같이 사용됨
		return todo;

	}

	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo newTodo =  Todo.builder()
				.id(null)
				.username(username)
				.description(todo.getDescription())
				.targetDate(todo.getTargetDate())
				.done(false)
				.build();
//		todo.setUsername(username);
//		todo.setId(null);
		return todoRepository.save(newTodo);// id값을 null로 해야 insert로 인식함
//		Todo createTodo = todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),todo.isDone());
//		return createTodo;

	}

}
