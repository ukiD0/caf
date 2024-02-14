package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.champ.R
import com.example.champ.databinding.FragmentSuccessfulBinding

class Successful : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuccessfulBinding.inflate(inflater)

        return binding.root
    }

}