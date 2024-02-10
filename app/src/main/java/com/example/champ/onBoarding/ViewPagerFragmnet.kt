package com.example.champ.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.champ.R
import com.example.champ.databinding.FragmentViewPagerFragmnetBinding
import com.example.champ.login.HomeFragment
import com.example.champ.login.LoginIn
import com.example.champ.onBoarding.screens.FirdFargment
import com.example.champ.onBoarding.screens.FirstFragment
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

        val fragmentlist = arrayListOf(
            FirstFragment(),
            SecondFragment(),
            FirdFargment(),
        )

        val adapter = ViewPagerAdapter(
            fragmentlist,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return binding.root
    }
}