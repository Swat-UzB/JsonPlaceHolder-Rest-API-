package com.example.jsonplaceholderrestapi.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholderrestapi.data.models.*
import com.example.jsonplaceholderrestapi.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponseAllPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val postsByUserId: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val postById: MutableLiveData<Response<Post>> = MutableLiveData()
    val photosByUserId: MutableLiveData<Response<List<Photo>>> = MutableLiveData()
    val allUsers: MutableLiveData<Response<List<User>>> = MutableLiveData()
    val albumsByUserId: MutableLiveData<Response<List<Album>>> = MutableLiveData()
    val commentsByPostId: MutableLiveData<Response<List<Comment>>> = MutableLiveData()
    fun getAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllPosts()
            withContext(Dispatchers.Main) {
                myResponseAllPosts.value = response
            }
        }
    }

    fun getPostsByUserId(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPostsByUserId(userId)
            withContext(Dispatchers.Main) {
                postsByUserId.value = response
            }
        }
    }

    fun getPostById(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPostById(postId)
            withContext(Dispatchers.Main) {
                postById.value = response
            }
        }
    }

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllUsers()
            withContext(Dispatchers.Main) {
                allUsers.value = response
            }
        }
    }

    fun getAlbumsByUserId(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAlbumsByUserId(userId)
            withContext(Dispatchers.Main) {
                albumsByUserId.value = response
            }
        }
    }

    fun getPhotosByUserId(albumId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPhotosByAlbumId(albumId)
            withContext(Dispatchers.Main) {
                photosByUserId.value = response
            }
        }
    }

    fun getCommentsByPostId(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCommentsByPostId(postId)
            withContext(Dispatchers.Main) {
                commentsByPostId.value = response
            }
        }
    }
}