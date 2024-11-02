package com.example.todolistapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
fun HomeTodoScreen(
    navController: NavController,
    viewModel: ToDoViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "ToDo List") }
            )
        },
        floatingActionButton =  {
            FloatingActionButton(
                onClick = { 
                    navController.navigate("add")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add ToDo"
                )
            }
        }
    ) {
        innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(viewModel.tasks) {
                Card (modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("detail/${it.id}")
                    }
                ){
                    Text(
                        text = it.title,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeTodoPreview() {
    HomeTodoScreen(rememberNavController(),ToDoViewModel())
}