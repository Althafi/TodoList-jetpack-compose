package com.example.todolistapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistapp.ui.add.AddTaskScreen
import com.example.todolistapp.ui.detail.DetailTaskScreen
import com.example.todolistapp.ui.home.HomeTodoScreen
import com.example.todolistapp.ui.viewModel.ToDoViewModel

@Composable
fun ToDoListApp(
    viewModel: ToDoViewModel
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home" ) {
        composable("home") {
            HomeTodoScreen(navController, viewModel)
        }
        composable("add") {
            AddTaskScreen(navController, viewModel)
        }
        composable("detail/{taskId}") {
            val taskId = it.arguments?.getString("taskId")
            DetailTaskScreen(navController, viewModel, taskId)
        }
    }

}