package com.example.jsonplaceholderrestapi.fragments.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderrestapi.data.models.Photo
import com.example.jsonplaceholderrestapi.databinding.ItemPhotosBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    private val dataList = mutableListOf<Photo>()

    fun setData(photoList: List<Photo>?) {
        if (photoList != null) {
            dataList.clear()
            dataList.addAll(photoList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotosAdapter.PhotosViewHolder {
        val binding = ItemPhotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosAdapter.PhotosViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount() = dataList.size

    class PhotosViewHolder(private val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(photo: Photo) {
            binding.photo = photo
        }
    }

}