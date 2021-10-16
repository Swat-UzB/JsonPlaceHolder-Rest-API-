package com.example.jsonplaceholderrestapi.fragments.profile

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.jsonplaceholderrestapi.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private val args: ProfileFragmentArgs by navArgs()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.window?.statusBarColor = Color.parseColor("#1F96FE")
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.user = args.user
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}