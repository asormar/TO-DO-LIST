package com.example.todolist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


//los dos puntos en Kotlin equivalen a extends en Java
class TaskViewModel : ViewModel() { // clase de Android que mantiene los datos vivos aunque la pantalla rote o se reconstruya

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private var nextId = 0

    fun addTask(title: String) {
        if (title.isBlank()) return
        _tasks.value = _tasks.value + Task(id = nextId++, title = title)
    }

    fun toggleTask(id: Int) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == id) task.copy(isDone = !task.isDone) else task
        }
    }
}