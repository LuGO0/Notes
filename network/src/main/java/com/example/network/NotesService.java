package com.example.network;

import com.example.commons.models.TodoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NotesService {

    @GET("facts")
    Call<List<TodoItem>> getTodoList();

}
