package com.example.champ.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.champ.BottomActivity
import com.example.champ.MainActivity
import com.example.champ.R
import com.example.champ.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val binding = FragmentHomeBinding.inflate(inflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.security.movementMethod = LinkMovementMethod.getInstance()

        binding.tvSignIn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_loginIn)
        }
        binding.google.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_bottomActivity)
            activity!!.finish()
            val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("isLogin",true)
            editor.apply()
        //activity!!.startActivity(Intent(activity, BottomActivity::class.java))
        }
        return binding.root
    }

}