package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentCallBinding


class Call : Fragment() {
    lateinit var binding: FragmentCallBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallBinding.inflate(inflater)

        val footer: CardView = activity!!.findViewById(R.id.cardView)
        footer.isVisible = false

        binding.exit.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_call_to_chatJames)
        }

        return binding.root
    }

}