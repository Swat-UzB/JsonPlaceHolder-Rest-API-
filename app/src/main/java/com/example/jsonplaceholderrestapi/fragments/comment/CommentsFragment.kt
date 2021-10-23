package com.example.jsonplaceholderrestapi.fragments.comment

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
import com.example.jsonplaceholderrestapi.R
import com.example.jsonplaceholderrestapi.data.repository.Repository
import com.example.jsonplaceholderrestapi.data.viewmodel.MainViewModel
import com.example.jsonplaceholderrestapi.databinding.FragmentCommentsBinding

class CommentsFragment : Fragment() {
    private val args: CommentsFragmentArgs by navArgs()
    private val commentAdapter: CommentAdapter by lazy { CommentAdapter() }
    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentCommentsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val postId = args.postId
        _binding = FragmentCommentsBinding.inflate(layoutInflater, container, false)
        binding.commentRecyclerView.apply {
            adapter = commentAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        }
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCommentsByPostId(postId)
        viewModel.commentsByPostId.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                binding.title.text =
                    getString(R.string.comment_str, response.body()?.size.toString())
                commentAdapter.setData(response.body())
            } else {
                Toast.makeText(
                    requireContext(),
                    "getCommentsByPostId ${response.code()}",
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