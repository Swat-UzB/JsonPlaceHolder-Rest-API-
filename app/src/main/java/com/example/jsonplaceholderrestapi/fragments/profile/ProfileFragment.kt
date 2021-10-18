package com.example.jsonplaceholderrestapi.fragments.profile

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.jsonplaceholderrestapi.R
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
        with(binding) {
//            viewPager2.adapter = TabPagerAdapter(this@ProfileFragment)
//            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
//                tab.text = when (position) {
//                    0 -> getString(R.string.albums)
//                    1 -> getString(R.string.posts)
//                    else -> getString(R.string.albums)
//                }
//            }.attach()
            this.user = args.user
            postsTextView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_postsFragment))
            albumsTextView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_albumsFragment))
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}