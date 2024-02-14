package com.example.champ.mainPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentTrackBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Track : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTrackBinding.inflate(inflater)

        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = true

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Track"

        binding.appCompatButton2.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_track_to_view_package)
        }

        return binding.root
    }

}