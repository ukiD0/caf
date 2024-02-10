package com.example.champ.onBoarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.champ.R
import com.example.champ.databinding.FragmentFirdFargmentBinding
import com.example.champ.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val binding = FragmentSecondBinding.inflate(inflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.frNext2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        binding.skip2.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return binding.root
    }
}