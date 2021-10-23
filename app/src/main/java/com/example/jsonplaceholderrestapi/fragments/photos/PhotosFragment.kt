package com.example.jsonplaceholderrestapi.fragments.photos

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jsonplaceholderrestapi.MainViewModelFactory
import com.example.jsonplaceholderrestapi.data.repository.Repository
import com.example.jsonplaceholderrestapi.data.viewmodel.MainViewModel
import com.example.jsonplaceholderrestapi.databinding.FragmentPhotosBinding


class PhotosFragment : Fragment() {
    private val photosAdapter: PhotosAdapter by lazy { PhotosAdapter() }
    private val args: PhotosFragmentArgs by navArgs()
    private var _binding: FragmentPhotosBinding? = null
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhotosBinding.inflate(inflater, container, false)
        activity?.window?.statusBarColor = Color.WHITE
        binding.photoRecyclerView.apply {
            adapter = photosAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        }
        val albumId = args.albumId
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPhotosByUserId(albumId)
        viewModel.photosByUserId.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                photosAdapter.setData(response.body())
            } else {
                Toast.makeText(
                    requireContext(),
                    "getPhotosByUserId: ${response.errorBody()}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}