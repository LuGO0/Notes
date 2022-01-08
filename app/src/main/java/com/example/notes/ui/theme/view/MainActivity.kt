package com.example.notes.ui.theme.view

import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.commons.models.TodoItem
import com.example.network.NetworkModule
import com.example.network.NotesService
import com.example.notes.BuildConfig.DEBUG
import com.example.notes.navigation.MainScreen
import com.example.notes.navigation.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var list: List<TodoItem>
        val retrofit: Retrofit = NetworkModule.provideRetrofit()
        val notesService: NotesService = NetworkModule.provideNotesService(retrofit = retrofit)

        
        
        setContent {
            runBlocking(Dispatchers.IO) {
                notesService.todoList.execute().body()?.let { list = it }
            }

            Log.d("foo", list.toString())
            TodoList(todoItems = list)
            Navigation()
        }
    }
}

private suspend fun populateList() {

}

//make some API calls get the todolist later

@Composable
fun TodoList(todoItems: List<com.example.commons.models.TodoItem>) {
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

