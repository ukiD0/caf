package com.example.champ.mainPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentProfileBinding


class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater)

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Profile"

        val btBack: ImageButton = activity!!.findViewById(R.id.bt_back)
        btBack.isVisible = false

        binding.switch1.setOnClickListener {
            if (binding.switch1.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.blockNotific.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_profile_to_notification_fragment)
        }





        return binding.root
    }

}