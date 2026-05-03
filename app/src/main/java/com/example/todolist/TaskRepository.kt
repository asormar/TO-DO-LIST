package com.example.todolist

import kotlinx.coroutines.flow.Flow

/*Es una capa fina que delega al Dao. Su utilidad es que el ViewModel no conoce Room directamente,
solo el Repository. Si en el futuro se cambia la base de datos, el ViewModel no se toca.*/
class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}