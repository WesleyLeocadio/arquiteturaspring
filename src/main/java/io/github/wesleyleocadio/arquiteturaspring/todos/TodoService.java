package io.github.wesleyleocadio.arquiteturaspring.todos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	private TodoValidator todoValidator;
	private MailSender todoMailSender;

	
	public TodoService(TodoRepository todoRepository, TodoValidator todoValidator,MailSender todoMailSender) {
		this.todoRepository = todoRepository;
		this.todoValidator = todoValidator;
		this.todoMailSender = todoMailSender;
	}
	
	public TodoEntity salvar(TodoEntity todo) {
		todoValidator.validar(todo);
		return todoRepository.save(todo);
	}
	
	public void atualizarEEnviarNotificacao(TodoEntity todo) {
		todo = salvar(todo);
	    enviarNotificacao(todo); 
	}
	
	private void enviarNotificacao(TodoEntity todo) {
	    String descricao = todo.getDescricao() != null ? todo.getDescricao() : "Sem descrição";
	    String status = Boolean.TRUE.equals(todo.getConcluido()) ? "CONCLUÍDO" : "NÃO CONCLUÍDO";
	    todoMailSender.enviar("Todo " + descricao + " foi atualizado para " + status);
	}

	public Optional<TodoEntity> buscarPorId(Integer id) {
		return todoRepository.findById(id);
	}

	public Optional<List<TodoEntity>> buscarTodos() {
		return Optional.of(todoRepository.findAll());
	}
}
