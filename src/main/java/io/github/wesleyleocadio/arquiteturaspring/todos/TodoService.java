package io.github.wesleyleocadio.arquiteturaspring.todos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public TodoEntity salvar(TodoEntity todo) {
		return todoRepository.save(todo);
	}
	
	public TodoEntity atualizarStatus(TodoEntity todo) {
		return todoRepository.save(todo);
	}

	public Optional<TodoEntity> buscarPorId(Integer id) {
		return todoRepository.findById(id);
	}

	public Optional<List<TodoEntity>> buscarTodos() {
		return Optional.of(todoRepository.findAll());
	}
}
