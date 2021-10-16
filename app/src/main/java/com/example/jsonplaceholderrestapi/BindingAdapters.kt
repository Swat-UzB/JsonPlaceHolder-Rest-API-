package com.example.jsonplaceholderrestapi

import android.util.Log
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView

class BindingAdapters {
    companion object {
        @BindingAdapter("android:setImageProfile")
        @JvmStatic
        fun setImageProfile(view: ShapeableImageView, userId: Int) {
            Log.d("rrrr",userId.toString())
            when (userId % 3) {
                0 -> view.setImageResource(R.drawable.image_1)
                1 -> view.setImageResource(R.drawable.image_2)
                2 -> view.setImageResource(R.drawable.image_3)
            }
        }
    }
}

