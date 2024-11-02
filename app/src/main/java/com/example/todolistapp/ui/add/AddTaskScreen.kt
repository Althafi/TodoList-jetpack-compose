package com.example.todolistapp.ui.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolistapp.model.Task
import com.example.todolistapp.ui.viewModel.ToDoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    navController: NavController,
    viewModel: ToDoViewModel
) {

    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add New Task") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {

                            val newTask = Task(
                                (viewModel.tasks.size + 1).toString(),
                                taskTitle,
                                taskDescription
                            )

                            viewModel.addTask(newTask)
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = "Save Task"
                        )
                    }
                }
            )
        }
    ) {
        innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
        ) {
            TextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(text = "Add Title")
                }
            )

            Spacer(modifier = Modifier.padding(4.dp))

            TextField(
                value = taskDescription,
                onValueChange = { taskDescription = it },
                modifier = Modifier
                    .fillMaxSize(),
                label = {
                    Text(text = "Add Description")
                }
            )
        }
    }
}

@Preview
@Composable
fun AddTaskPreview() {
    AddTaskScreen(rememberNavController() ,ToDoViewModel())
}