package com.example.notes.ui.theme.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.notes.navigation.MainScreen
import com.example.notes.ui.theme.view.TodoItemProto.TodoItem.newBuilder
import notes.TodoItemKt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var builder = notes.TodoItemProto.TodoItem.
//        var foo = TodoItemKt.Dsl._create()
//
//
//        val list: List<TodoItemProto> = mutableListOf(
//            TodoItemProto.newBuilder()
//                .setTitle("foo")
//                .setDetails("zoo")
//                .build(),
//            TodoItemProto.newBuilder()
//                .setTitle("foooo")
//                .setDetails("zoo")
//                .build()
//        )

        //some Issue with kotlin generation code in java so I will see this later and fix this

        setContent {
            TodoList(todoItems = list)
            //Navigation()
        }
    }
}

//make some API calls get the todolist later

@Composable
fun TodoList(todoItems: List<TodoItemProto>) {
    LazyColumn(content = {
        items(todoItems.size) { index ->
            Text(todoItems[index].toString())
        }
    })
}

@Preview
@Composable
fun foo() {

//    val list: List<TodoItem> = mutableListOf(
//        TodoItem("foo","zoo"),
//        TodoItem("foooo","zoooo"))
//
//    TodoList(todoItems = list)
    MainScreen(navController = rememberNavController())
}

