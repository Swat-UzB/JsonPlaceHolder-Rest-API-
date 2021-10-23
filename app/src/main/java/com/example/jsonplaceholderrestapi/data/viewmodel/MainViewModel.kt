package com.example.jsonplaceholderrestapi.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholderrestapi.data.models.Album
import com.example.jsonplaceholderrestapi.data.models.Photo
import com.example.jsonplaceholderrestapi.data.models.Post
import com.example.jsonplaceholderrestapi.data.models.User
import com.example.jsonplaceholderrestapi.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponseAllPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val postsByUserId: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val postById: MutableLiveData<Response<Post>> = MutableLiveData()
    val photosByUserId: MutableLiveData<Response<List<Photo>>> = MutableLiveData()
    val allUsers: MutableLiveData<Response<List<User>>> = MutableLiveData()
    val albumsByUserId: MutableLiveData<Response<List<Album>>> = MutableLiveData()
    fun getAllPosts() {
        viewModelScope.launch {
            val response = repository.getAllPosts()
            myResponseAllPosts.value = response
        }
    }

    fun getPostsByUserId(userId: Int) {
        viewModelScope.launch {
            val response = repository.getPostsByUserId(userId)
            postsByUserId.value = response
        }
    }

    fun getPostById(postId: Int) {
        viewModelScope.launch {
            val response = repository.getPostById(postId)
            postById.value = response
        }
    }

    fun getAllUsers() {
        viewModelScope.launch {
            val response = repository.getAllUsers()
            allUsers.value = response
        }
    }

    fun getAlbumsByUserId(userId: Int) {
        viewModelScope.launch {
            val response = repository.getAlbumsByUserId(userId)
            albumsByUserId.value = response
        }
    }

    fun getPhotosByUserId(albumId: Int) {
        viewModelScope.launch {
            val response = repository.getPhotosByAlbumId(albumId)
            photosByUserId.value = response
        }
    }
}