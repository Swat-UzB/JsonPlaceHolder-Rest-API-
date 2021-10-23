package com.example.jsonplaceholderrestapi

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            setTheme(R.style.AppTheme_Day)
//        } else {
//            setTheme(R.style.AppTheme_Day)
//        }
        setTheme(R.style.Theme_JsonPlaceHolderRestApi)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}