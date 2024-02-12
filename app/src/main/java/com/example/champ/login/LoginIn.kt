package com.example.champ.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.champ.R
import com.example.champ.databinding.FragmentLoginInBinding


class LoginIn : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginInBinding.inflate(inflater)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.tvSignIn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginIn_to_homeFragment)
        }
        binding.forgotPass.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_loginIn_to_forgotpassword)
        }
        return binding.root
    }

}