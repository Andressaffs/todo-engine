package br.com.andressa.service

import br.com.andressa.model.Todo
import br.com.andressa.repository.TodoRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class TodoServiceImpl (private val todoRepository: TodoRepository): TodoService {


    override fun getTodos(): List<Todo> {
        return todoRepository.getCql(Todo())
    }

    override fun getByIdTodo(id: UUID): Todo? {
        return todoRepository.getByIdCql(id)
    }
}