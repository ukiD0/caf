package com.example.champ.mainPages.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentTransitionBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class transition : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTransitionBinding.inflate(inflater)
        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false
        val header: CardView = activity!!.findViewById(R.id.cardView)
        header.isVisible = false

        lifecycleScope.launch {
            binding.imgOkey.visibility = View.GONE
            binding.transSuc.visibility = View.GONE
            binding.appCompatButton.isEnabled = false
            withContext(Dispatchers.IO) {
                Thread.sleep(3000)
            }
            binding.imgOkey.visibility = View.VISIBLE
            binding.transSuc.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
            binding.appCompatButton.isEnabled = true
        }

        binding.toHome.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_transition_to_main_screen2)
        }

        binding.appCompatButton.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_transition_to_track)
        }

        return binding.root
    }


}