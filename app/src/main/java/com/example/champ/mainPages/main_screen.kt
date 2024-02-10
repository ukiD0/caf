package com.example.champ.mainPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.champ.R
import com.example.champ.databinding.FragmentMainScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class main_screen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainScreenBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        return binding.root
    }


}