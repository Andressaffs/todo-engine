package br.com.andressa.service

import br.com.andressa.model.Todo
import java.util.*
import javax.inject.Singleton

@Singleton
interface TodoService {

    fun getTodos(): List<Todo>
    fun getByIdTodo(id: UUID): Todo?
}