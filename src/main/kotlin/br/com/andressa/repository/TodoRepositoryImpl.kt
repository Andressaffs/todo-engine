package br.com.andressa.repository

import br.com.andressa.model.Todo
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class TodoRepositoryImpl(private val cqlSession: CqlSession) : TodoRepository {

    override fun getCql(todo: Todo): List<Todo> {
        val all = cqlSession.execute(SimpleStatement.newInstance("SELECT*FROM todo.Todo"))
        return all.map {
            Todo(
                it.getUuid("id"),
                it.getString("date")!!,
                it.getString("description")!!,
                it.getBoolean("done")
            )
        }.toList()

    }

    override fun getByIdCql(id: UUID): Todo? {
        val result = cqlSession.execute(SimpleStatement.newInstance("SELECT*FROM todo.Todo WHERE id=?"))
        return result.map { todo ->
            Todo(
                todo.getUuid("id")!!,
                todo.getString("date")!!,
                todo.getString("description")!!,
                todo.getBoolean("done")!!
            )
        }.firstOrNull()

    }
}