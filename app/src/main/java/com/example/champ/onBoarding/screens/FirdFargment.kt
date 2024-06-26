package com.example.champ.onBoarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.champ.R
import com.example.champ.databinding.FragmentFirdFargmentBinding

class FirdFargment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFirdFargmentBinding.inflate(inflater)

        binding.finish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragmnet_to_homeFragment)
            onBoardingFinished()
        }

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragmnet_to_loginIn)
            onBoardingFinished()
        }

        return binding.root
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }

}