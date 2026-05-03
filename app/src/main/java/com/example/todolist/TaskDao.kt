package com.example.todolist

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao //marca la interfaz como objeto de acceso a datos
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>> //Room emitirá automáticamente la lista actualizada cada vez que cambie la base de datos

    @Insert
    suspend fun insertTask(task: Task)
    // suspend sirve para que lass funciones sean asíncronas (como await)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}