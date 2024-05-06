package com.example.champ.onBoarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.champ.databinding.FragmentViewPagerFragmnetBinding
import com.example.champ.onBoarding.screens.FirdFargment
import com.example.champ.onBoarding.screens.SecondFragment
import java.util.LinkedList
import java.util.Queue

class ViewPagerFragmnet: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerFragmnetBinding.inflate(inflater)

//        val fragmentlist = arrayListOf(
//            FirstFragment(),
//            SecondFragment(),
//            FirdFargment(),
//        )
//
//        val adapter = ViewPagerAdapter(
//            fragmentlist,
//            requireActivity().supportFragmentManager,
//            lifecycle
//        )
//
//        binding.viewPager.adapter = adapter
        val queue: Queue<Fragment> = LinkedList<Fragment>().apply {
            add(FirdFargment())
            add(SecondFragment())
            add(FirdFargment())
        }


        val adapter = ViewPagerAdapter(
            queue,
            requireActivity(),
            lifecycle
        )
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val state = sharedPref.getInt("boardState", 0)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = state
        return binding.root
    }
}
