package com.example.jsonplaceholderrestapi.fragments.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderrestapi.data.models.Comment
import com.example.jsonplaceholderrestapi.databinding.CommentItemBinding

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    private val dataList = mutableListOf<Comment>()

    fun setData(commentList: List<Comment>?) {
        if (commentList != null) {
            dataList.clear()
            dataList.addAll(commentList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentAdapter.CommentViewHolder {
        val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentAdapter.CommentViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount() = dataList.size

    class CommentViewHolder(private val binding: CommentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(comment: Comment) {
            binding.comment = comment
            binding.executePendingBindings()
        }
    }

}