package com.example.jsonplaceholderrestapi.fragments.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jsonplaceholderrestapi.LoadingDialog
import com.example.jsonplaceholderrestapi.MainViewModelFactory
import com.example.jsonplaceholderrestapi.data.repository.Repository
import com.example.jsonplaceholderrestapi.data.viewmodel.MainViewModel
import com.example.jsonplaceholderrestapi.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var loading: LoadingDialog
    private var _binding: FragmentHomeBinding? = null
    private val userAdapter: UserAdapter by lazy { UserAdapter() }
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        loading = LoadingDialog(this)
        loading.startLoadingDialog()
        requireActivity().window.statusBarColor
        activity?.window?.statusBarColor = Color.WHITE
        val repository = Repository()

        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(
            MainViewModel::
            class.java
        )
        viewModel.getAllUsers()
        viewModel.allUsers.observe(requireActivity(), Observer
        { response ->
            if (response.isSuccessful) with(response.body()) {
                userAdapter.setData(response.body())
                Log.d(TAG, response.body()?.size.toString())
                loading.dismissDialog()
            } else {
                Log.d(TAG, response.errorBody().toString())
            }

        })
        binding.userRecyclerView.apply {
            adapter = userAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        }

        return binding.root
    }



    companion object {
        private const val TAG = "RRRR"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}