package com.example.notes.ui.theme.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.commons.models.Note
import com.example.network.NetworkModule
import com.example.network.NotesService
import com.example.notes.navigation.MainScreen
import com.example.notes.navigation.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var list: List<Note>
        val retrofit: Retrofit = NetworkModule.provideRetrofit()
        val notesService: NotesService = NetworkModule.provideNotesService(retrofit = retrofit)




        setContent {



            runBlocking(Dispatchers.IO) {
                val res1 = notesService.saveNote(Note("foo", "bar")).execute()
                val res2 = notesService.saveNote(Note("foo1", "bar1")).execute()

                val res3 = notesService.deleteNote(2)

                val ers4 = notesService.notes.execute().body()?.let { list = it }
            }

            Log.d("foo", list.toString())
            TodoList(notes = list)
            Navigation()
        }
    }
}

private suspend fun populateList() {

}

//make some API calls get the todolist later

@Composable
fun TodoList(notes: List<com.example.commons.models.Note>) {
    LazyColumn(content = {
        items(notes.size) { index ->
            Text(notes[index].toString())
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

