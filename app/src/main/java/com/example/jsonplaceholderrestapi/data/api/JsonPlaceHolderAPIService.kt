package com.example.jsonplaceholderrestapi.data.api

import com.example.jsonplaceholderrestapi.data.models.*
import retrofit2.Response
import retrofit2.http.*

interface JsonPlaceHolderAPIService {
    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>

    @GET("posts")
    suspend fun getPostsByUserId(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    @GET("posts/{postId}")
    suspend fun getPostById(
        @Path("postId") postId: Int
    ): Response<Post>

    @GET("comments")
    suspend fun getAllComments(): Response<List<Comment>>

    @GET("comments/{commentId}")
    suspend fun getCommentById(
        @Path("commentId") commentId: Int
    ): Response<Comment>

    @GET("comments")
    suspend fun getCommentsByPostId(
        @Query("postId") postId: Int
    ): Response<List<Comment>>

    @GET("albums")
    suspend fun getAllAlbums(): Response<List<Album>>

    @GET("albums/{albumId}")
    suspend fun getAlbumById(
        @Path("albumId") albumId: Int
    ): Response<Album>

    @GET("albums")
    suspend fun getAlbumsByUserId(
        @Query("userId") userId: Int
    ): Response<List<Album>>

    @GET("photos")
    suspend fun getAllPhotos(): Response<List<Photo>>

    @GET("photos/{photoId}")
    suspend fun getPhotoById(
        @Path("photoId") photoId: Int
    ): Response<Photo>

    @GET("photos")
    suspend fun getPhotosByAlbumId(
        @Query("albumId") albumId: Int
    ): Response<List<Photo>>

    @GET("todos")
    suspend fun getAllTodos(): Response<List<ToDo>>

    @GET("todos/{todoId}")
    suspend fun getTodoById(
        @Path("todoId") todoId: Int
    ): Response<ToDo>

    @GET("todos")
    suspend fun getTodosByUserId(
        @Query("userId") userId: Int
    ): Response<List<ToDo>>

    @GET("users")
    suspend fun getAllUsers(): Response<List<User>>

    @GET("users/{userId}")
    suspend fun getUserById(
        @Path("userId") userId: Int
    ): Response<User>

    @DELETE("posts/{postNumber}")
    suspend fun deletePost(
        @Path("postNumber") postId: Int
    ): Response<String>

    @POST("posts")
    suspend fun postsByPost(): Response<String>

}