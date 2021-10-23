package com.example.jsonplaceholderrestapi.fragments.albums

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderrestapi.R
import com.example.jsonplaceholderrestapi.data.models.Album
import com.example.jsonplaceholderrestapi.databinding.AlbumItemBinding
import com.example.jsonplaceholderrestapi.util.Constants.Companion.USER_ID

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    private var dataList = emptyList<Album>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(albumList: List<Album>?) {
        if (albumList != null) {
            dataList = albumList
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount() = dataList.size


    class AlbumViewHolder(private val binding: AlbumItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(album: Album) {
            binding.album = album
        }
    }


}