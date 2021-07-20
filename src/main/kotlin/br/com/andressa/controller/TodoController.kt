package br.com.andressa.controller

import br.com.andressa.model.Todo
import br.com.andressa.service.TodoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/todos")
class TodoController(private val todoService: TodoService) {

    @Get
    fun getTodos(): HttpResponse<List<Todo>> {
        return HttpResponse.ok(todoService.getTodos())
    }

    @Get("/{id}")
    fun getByIdTodo(@PathVariable("id") id: UUID): HttpResponse<Todo> {
        return HttpResponse.ok(this.todoService.getByIdTodo(id))
    }
}