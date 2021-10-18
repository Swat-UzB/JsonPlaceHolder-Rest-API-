package com.example.jsonplaceholderrestapi

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import java.util.*

class BindingAdapters {
    companion object {
        @BindingAdapter("android:setImageProfile")
        @JvmStatic
        fun setImageProfile(view: ShapeableImageView, userId: Int) {
            Log.d("rrrr", userId.toString())
            when (userId % 3) {
                0 -> view.setImageResource(R.drawable.image_1)
                1 -> view.setImageResource(R.drawable.image_2)
                2 -> view.setImageResource(R.drawable.image_3)
            }
        }

        @BindingAdapter("android:openWebsite")
        @JvmStatic
        fun openWebsite(view: View, uri: String) {
            view.setOnClickListener {
                Log.d("rrrr", uri)
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                view.context.startActivity(browserIntent)
            }
        }

        @BindingAdapter("android:openGeo")
        @JvmStatic
        fun openGeo(view: View, geo: String) {
            view.setOnClickListener {
                val geo1 = "geo:41.275562,69.204504,"
                Log.d("rrrr", geo)
                val uri = String.format(Locale.ENGLISH, geo1)
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                view.context.startActivity(browserIntent)
            }
        }

        @BindingAdapter("android:sendMail")
        @JvmStatic
        fun sendMail(view: View, mailAddress: String) {
            val mailIntent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, mailAddress)
            }
            view.context.startActivity(mailIntent)
        }

        @BindingAdapter("android:downloadImage")
        @JvmStatic
        fun downloadImage(view: View, uri: String) {
            Glide.with(view.context)
                .load(Uri.parse(uri))
                .into(view as ImageView)

        }
    }
}


