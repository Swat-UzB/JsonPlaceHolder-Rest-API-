package com.example.jsonplaceholderrestapi.data.repository

import com.example.jsonplaceholderrestapi.data.api.RetrofitInstance
import com.example.jsonplaceholderrestapi.data.models.*
import retrofit2.Response

class Repository {
    suspend fun getAllPosts(): Response<List<Post>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAllPosts()
    }

    suspend fun getPostsByUserId(userId: Int): Response<List<Post>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getPostsByUserId(userId)
    }

    suspend fun getPostById(postId: Int): Response<Post> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getPostById(postId)
    }

    suspend fun getAllComments(): Response<List<Comment>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAllComments()
    }

    suspend fun getCommentById(commentId: Int): Response<Comment> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getCommentById(commentId)
    }

    suspend fun getCommentsByPostId(postId: Int): Response<List<Comment>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getCommentsByPostId(postId)
    }

    suspend fun getAllAlbums(): Response<List<Album>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAllAlbums()
    }

    suspend fun getAlbumById(albumId: Int): Response<Album> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAlbumById(albumId)
    }

    suspend fun getAlbumsByUserId(userId: Int): Response<List<Album>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAlbumsByUserId(userId)
    }

    suspend fun getAllPhotos(): Response<List<Photo>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAllPhotos()
    }

    suspend fun getPhotoById(photoId: Int): Response<Photo> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getPhotoById(photoId)
    }

    suspend fun getPhotosByAlbumId(albumId: Int): Response<List<Photo>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getPhotosByAlbumId(albumId)
    }

    suspend fun getAllTodos(): Response<List<ToDo>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAllTodos()
    }

    suspend fun getTodoById(todoId: Int): Response<ToDo> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getTodoById(todoId)
    }

    suspend fun getTodosByUserId(userId: Int): Response<List<ToDo>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getTodosByUserId(userId)
    }

    suspend fun getAllUsers(): Response<List<User>> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getAllUsers()
    }

    suspend fun getUserById(userId: Int): Response<User> {
        return RetrofitInstance.jsonPlaceHolderAPIService.getUserById(userId)
    }

    suspend fun deletePost(postId: Int): Response<String> {
        return RetrofitInstance.jsonPlaceHolderAPIService.deletePost(postId)
    }


    suspend fun postsByPost(): Response<String> {
        return RetrofitInstance.jsonPlaceHolderAPIService.postsByPost()
    }

}