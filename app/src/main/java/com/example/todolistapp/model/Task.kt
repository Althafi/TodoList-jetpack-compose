package com.example.todolistapp.model

data class Task(
    val id: String,
    val title: String,
    val description: String? = null
)
