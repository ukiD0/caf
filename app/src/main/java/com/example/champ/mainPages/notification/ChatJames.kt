package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentChatJamesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChatJames : Fragment() {
    lateinit var binding: FragmentChatJamesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatJamesBinding.inflate(inflater)

        val bottom: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        bottom.isVisible = false

//        val icon: TextView = activity!!.findViewById(R.id.tvheader)
//        icon.resources.getDrawable(R.drawable.profilr)

        val header: CardView = activity!!.findViewById(R.id.cardView)
        header.isVisible = false

        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_chatJames_to_chat)
        }

        binding.phone.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_chatJames_to_call)
        }

        return binding.root
    }



}