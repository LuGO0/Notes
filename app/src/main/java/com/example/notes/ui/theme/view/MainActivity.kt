package com.example.notes.ui.theme.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.data.NotesViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val notesViewModel: NotesViewModel by viewModels()

        setContent {
            TodoList(notesViewModel = notesViewModel)
            //Navigation()
        }
    }
}

@Composable
fun TodoList(notesViewModel: NotesViewModel) {
    // bad bad stateful compose we need to take this out of the compose.
    val isRefreshing by notesViewModel.isRefreshing.observeAsState(initial = false)
    val notes by notesViewModel.notes.observeAsState(emptyList())

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { notesViewModel.refresh() },
    ) {
        LazyColumn(content = {
            items(notes.size) { index ->
                Text(notes[index].toString())
            }
        })
    }
}

@Preview
@Composable
fun foo() {

//    val list: List<TodoItem> = mutableListOf(
//        TodoItem("foo","zoo"),
//        TodoItem("foooo","zoooo"))
//
//    TodoList(todoItems = list)
    //MainScreen(navController = rememberNavController())
}

