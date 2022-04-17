package com.example.network;

import com.example.commons.models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NotesService {

    @GET("notes/")
    Call<List<Note>> getNotes();

    @GET("notes/{Id}")
    Call<Note> getNote(@Path("Id") Long Id);

    @POST("notes/")
    Call<Note> saveNote(@Body Note note);

    @POST("notes/{Id}")
    Call<Note> updateNote(@Path("Id") Long Id);

    @DELETE("notes/{Id}")
    Call<Void> deleteNote(@Path("Id") Long Id);

}
