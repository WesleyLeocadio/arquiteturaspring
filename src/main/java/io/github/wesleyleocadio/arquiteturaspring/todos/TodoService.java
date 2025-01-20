package io.github.wesleyleocadio.arquiteturaspring.todos;

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
}
