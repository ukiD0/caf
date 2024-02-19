package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentChatBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Chat : Fragment() {
    private lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)

        val tvheader23: CardView = activity!!.findViewById(R.id.cardView)
        tvheader23.isVisible = true

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Chats"

        val bt: ImageButton = activity!!.findViewById(R.id.bt_back)
        bt.isVisible = true
        bt.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_chat_to_main_screen2)
        }

        val bottom: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        bottom.isVisible = false

        binding.cardView2.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_chat_to_chatJames)
        }

        return binding.root
    }



}