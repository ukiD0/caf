package com.example.champ.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.champ.onBoarding.screens.FirdFargment
import com.example.champ.onBoarding.screens.FirstFragment
import com.example.champ.onBoarding.screens.SecondFragment
import java.util.Queue

class ViewPagerAdapter(
    private val list: Queue<Fragment>,
    private val requireActivity: FragmentActivity,
    lifecycle: Lifecycle): FragmentStateAdapter(requireActivity.supportFragmentManager,lifecycle) {

    private val queue = ArrayList<Fragment>().apply {
        add(FirstFragment())
        add(SecondFragment())
        add(FirdFargment())
    }

    override fun getItemCount(): Int {
        return queue.size
    }

    override fun createFragment(position: Int): Fragment {

        return queue[position]
    }


}