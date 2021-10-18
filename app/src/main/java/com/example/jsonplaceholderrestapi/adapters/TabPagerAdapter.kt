package com.example.jsonplaceholderrestapi.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jsonplaceholderrestapi.fragments.albums.AlbumsFragment
import com.example.jsonplaceholderrestapi.fragments.posts.PostsFragment

class TabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlbumsFragment()
            1 -> PostsFragment()
            else -> AlbumsFragment()
        }
    }
}