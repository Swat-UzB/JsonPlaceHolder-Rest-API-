package com.example.jsonplaceholderrestapi.fragments.posts

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
import com.example.jsonplaceholderrestapi.databinding.FragmentPostsBinding

class PostsFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private val postAdapter: PostAdapter by lazy { PostAdapter() }
    private var _binding: FragmentPostsBinding? = null
    private val args: PostsFragmentArgs by navArgs()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        activity?.window?.statusBarColor = Color.WHITE
        val userId = args.userId
        binding.postsRecyclerView.apply {
            adapter = postAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        }
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPostsByUserId(userId)
        viewModel.postsByUserId.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                postAdapter.setData(response.body())
            } else {
                Toast.makeText(
                    requireContext(),
                    "getPostsByUserId: ${response.errorBody()}",
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