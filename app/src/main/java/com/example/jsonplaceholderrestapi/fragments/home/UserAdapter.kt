package com.example.jsonplaceholderrestapi.fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderrestapi.data.models.User
import com.example.jsonplaceholderrestapi.databinding.UserItemBinding

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var dataList = emptyList<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(userList: List<User>?) {
        if (userList != null) {
            dataList = userList
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount() = dataList.size

    class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }
}