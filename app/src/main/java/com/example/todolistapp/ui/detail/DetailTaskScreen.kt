package com.example.todolistapp.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolistapp.ui.viewModel.ToDoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTaskScreen(
    navController: NavController,
    viewModel: ToDoViewModel,
    taskId: String?
) {

    val task = viewModel.getTaskById(taskId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail Task ${task?.title}") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.deleteTask(task?.id ?: "")
                            navController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete All Task")
                    }
                }
            )
        }
    ) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = task?.description ?: "",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun DetailTaskPreview() {
    DetailTaskScreen(rememberNavController() ,ToDoViewModel(), "2")
}
