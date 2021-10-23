package com.example.jsonplaceholderrestapi.fragments.albums

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
import com.example.jsonplaceholderrestapi.databinding.FragmentAlbumsBinding


class AlbumsFragment : Fragment() {
    private val args: AlbumsFragmentArgs by navArgs()
    private val albumAdapter by lazy { AlbumAdapter() }
    private var _binding: FragmentAlbumsBinding? = null
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlbumsBinding.inflate(layoutInflater, container, false)
        activity?.window?.statusBarColor = Color.WHITE
        binding.albumsRecyclerView.apply {
            adapter = albumAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getAlbumsByUserId(args.userId)
        viewModel.albumsByUserId.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                albumAdapter.setData(response.body())
            } else {
                Toast.makeText(
                    requireContext(),
                    "getAlbumsByUserId: ${response.errorBody()}",
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