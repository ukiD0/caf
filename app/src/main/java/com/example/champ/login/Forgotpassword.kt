package com.example.champ.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentForgotpasswordBinding

class Forgotpassword : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val binding = FragmentForgotpasswordBinding.inflate(inflater)

        binding.tvSignIn.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_forgotpassword_to_loginIn)
        }
        binding.senOTP.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_forgotpassword_to_OTPverif)
        }


        return binding.root
    }

}