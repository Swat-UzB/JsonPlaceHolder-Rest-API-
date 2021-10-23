package com.example.jsonplaceholderrestapi

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.jsonplaceholderrestapi.data.models.User
import com.example.jsonplaceholderrestapi.fragments.albums.AlbumsFragmentDirections
import com.example.jsonplaceholderrestapi.fragments.home.HomeFragmentDirections
import com.example.jsonplaceholderrestapi.fragments.posts.PostsFragmentDirections
import com.example.jsonplaceholderrestapi.fragments.profile.ProfileFragmentDirections
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

        @BindingAdapter(
            value = ["albumId", "type"]
        )
        @JvmStatic
        fun downloadImage(view: View, albumId: Int, type: Int) {
            val uri1 = when (type) {
                0 -> "https://picsum.photos/id/${1 + (albumId - 1) * 10}/150/150"
                1 -> {
                    "https://picsum.photos/id/${albumId % 1000}/300/600"
                }
                else -> ""
            }
            Glide.with(view.context)
                .load(Uri.parse(uri1))
                .placeholder(R.drawable.placeholder)
                .into(view as ImageView)
        }

        @BindingAdapter("android:sendDataToProfileFragment")
        @JvmStatic
        fun sendDataToProfileFragment(view: ConstraintLayout, user: User) {
            view.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragment2ToProfileFragment(user)
                view.findNavController().navigate(action)
            }
        }

        @BindingAdapter("android:sendDataToAnotherFragment")
        @JvmStatic
        fun sendDataToPostsFragment(view: TextView, userId: Int) {
            val action =
                when (view.id) {
                    R.id.albums_text_view -> ProfileFragmentDirections.actionProfileFragmentToAlbumsFragment(
                        userId
                    )
                    R.id.posts_text_view -> ProfileFragmentDirections.actionProfileFragmentToPostsFragment(
                        userId
                    )
                    R.id.comment_text_view -> PostsFragmentDirections.actionPostsFragmentToCommentsFragment(
                        userId
                    )
                    else -> ProfileFragmentDirections.actionProfileFragmentToAlbumsFragment(
                        userId
                    )
                }
            view.setOnClickListener {
                view.findNavController().navigate(action)
            }
        }

        @BindingAdapter("android:sendDataToPhotosFragment")
        @JvmStatic
        fun sendDataToPhotosFragment(view: ConstraintLayout, albumId: Int) {
            view.setOnClickListener {
                val action =
                    AlbumsFragmentDirections.actionAlbumsFragmentToPhotosFragment(albumId)
                view.findNavController().navigate(action)
            }
        }

        @BindingAdapter("android:likeAction")
        @JvmStatic
        fun likeAction(view: TextView, liked: Boolean) {

            view.setOnClickListener {
                if (!view.text.equals("like")) {
                    view.text = "like"
                    view.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_like,
                        0,
                        0,
                        0
                    )
                } else {
                    view.text = "liked"
                    view.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_liked,
                        0,
                        0,
                        0
                    )
                }
            }
        }
    }
}

