package com.example.notes.ui.theme.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.models.TodoItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list: List<TodoItem> = mutableListOf(
            TodoItem("foo","zoo"),
            TodoItem("foooo","zoooo"))

        setContent {
            TodoList(todoItems = list)
        }
    }
}

//make some API calls get the todolist later

@Composable
fun TodoList(todoItems: List<TodoItem>){
    LazyColumn(content = {
        items(todoItems.size){ index ->
            Text(todoItems[index].toString())
        }
    })
}

@Preview
@Composable
fun foo(){

    val list: List<TodoItem> = mutableListOf(
        TodoItem("foo","zoo"),
        TodoItem("foooo","zoooo"))

    TodoList(todoItems = list)
}
