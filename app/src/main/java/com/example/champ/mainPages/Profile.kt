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
import com.example.champ.BottomActivity
import com.example.champ.R
import com.example.champ.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater)

        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = true

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Profile"

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

        binding.linearLayoutCompat6.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_profile_to_add_payment_fragment)
        }

        binding.LLsendpackeg.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_profile_to_send_packeg_fragment)
        }



        return binding.root
    }

}