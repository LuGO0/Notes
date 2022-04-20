package com.example.network

import com.example.commons.models.Note
import retrofit2.Response
import retrofit2.http.*

interface NoteService {
    // If we use suspend function here then It will always call Call.enqueue() instead of call.execute()

    @GET("notes/")
    suspend fun getNotes(): Response<List<Note>>;

    @GET("notes/{Id}")
    suspend fun getNote(@Path("Id") Id: Long): Response<Note>

    @POST("notes/")
    suspend fun saveNote(@Body note: Note): Response<Note>

    @POST("notes/{Id}")
    suspend fun updateNote(@Body note: Note, @Path("Id") Id: Long): Response<Note>

    @DELETE("notes/{Id}")
    suspend fun deleteNote(@Path("Id") Id: Long): Response<Void>
}