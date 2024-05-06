package com.example.champ.onBoarding.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.champ.R
import com.example.champ.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFirstBinding.inflate(inflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.frNext.setOnClickListener {
            viewPager?.currentItem = 1
            saveState(1)
        }

        binding.skip.setOnClickListener {
            viewPager?.currentItem = 2
            saveState(2)
        }

        return binding.root
    }
    private fun saveState(position: Int){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        sharedPref.edit().apply {
            putInt("boardState", position)
            apply()
        }
    }

}