package io.github.wesleyleocadio.arquiteturaspring.todos;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService){
		this.todoService = todoService;
	}
	
	@PostMapping
	public ResponseEntity<TodoEntity> salvar(@RequestBody TodoEntity todo) {
	    TodoEntity todoEntity = todoService.salvar(todo);
	 // Cria a URI do novo recurso, usando o ID do TodoEntity
        UriComponents uriBuilder = UriComponentsBuilder
                .fromPath("/todos/{id}")
                .buildAndExpand(todoEntity.getId());
     // Retorna a resposta com status CREATED (201) e a URI do novo recurso
        return ResponseEntity.created(uriBuilder.toUri()).body(todoEntity);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TodoEntity> buscarPorId(@PathVariable("id") Integer id) {
		TodoEntity todo = todoService.buscarPorId(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo com id " + id + " não encontrado."));
		return ResponseEntity.ok(todo);
	}
	
	@GetMapping
	public ResponseEntity<List<TodoEntity>> buscarTodos() {
		Optional<List<TodoEntity>> listTodos = todoService.buscarTodos();

		// Se a lista estiver vazia, retorna 204 (No Content)
	    if (listTodos.isEmpty() || listTodos.get().isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(listTodos.get());
	}
	
}
