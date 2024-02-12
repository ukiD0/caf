package com.example.champ.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentNewPasswordBinding

class NewPassword : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewPasswordBinding.inflate(inflater)

        binding.btLoginIn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_newPassword_to_loginIn)
        }

        return binding.root
    }

}