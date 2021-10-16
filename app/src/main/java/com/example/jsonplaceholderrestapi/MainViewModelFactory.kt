package com.example.jsonplaceholderrestapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jsonplaceholderrestapi.data.repository.Repository
import com.example.jsonplaceholderrestapi.data.viewmodel.MainViewModel

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}