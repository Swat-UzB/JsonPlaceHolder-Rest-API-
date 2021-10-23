package com.example.jsonplaceholderrestapi.fragments.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderrestapi.data.models.Post
import com.example.jsonplaceholderrestapi.databinding.PostItemBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private val dataList = mutableListOf<Post>()

    fun setData(postList: List<Post>?) {
        if (postList != null) {
            dataList.clear()
            dataList.addAll(postList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostAdapter.PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount() = dataList.size

    class PostViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}