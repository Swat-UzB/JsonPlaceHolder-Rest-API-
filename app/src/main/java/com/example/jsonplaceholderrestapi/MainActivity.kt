package com.example.jsonplaceholderrestapi

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jsonplaceholderrestapi.data.repository.Repository
import com.example.jsonplaceholderrestapi.data.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_JsonPlaceHolderRestApi)
//        val splashScreen = SplashScreen.OnExitAnimationListener {  }
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPostById(1)
        viewModel.postById.observe(this, Observer { response ->
            if (response.isSuccessful) {
                with(response.body()) {
                    Log.d("RRR", "id: ${this?.id} ${response.code()}")
                    Log.d("RRR", "title: ${this?.title}")
                    Log.d("RRR", "id: ${this?.body}")
                    Log.d("RRR", "id: ${this?.userId}")
                }
            }
        })
    }
}