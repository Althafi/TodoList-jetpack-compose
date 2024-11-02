package com.example.todolistapp.ui.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todolistapp.model.Task

class ToDoViewModel: ViewModel() {

    private var _tasks = mutableStateListOf(
        Task("1", "Office", null),
        Task("2", "Home", "Learn Android Native"),
        Task("3", "Home", "Learn Android With Jetpack Compose")
    )

    val tasks: List<Task>
        get() = _tasks

    fun getTaskById(taskId: String?):Task? {
        val findId = _tasks.find { it.id == taskId }
        return findId
    }

    fun addTask(task: Task) {
        _tasks.add(task)
    }

    fun deleteTask(taskId: String) {
        _tasks.removeAll{it.id == taskId}
    }
}