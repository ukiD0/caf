package com.example.champ.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.Queue

class ViewPagerAdapter(
    list: Queue<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle): FragmentStateAdapter(fm,lifecycle) {

    private val fragmentList = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return  fragmentList[position]
    }


}