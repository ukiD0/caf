package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.champ.R
import com.example.champ.databinding.FragmentSend2PackageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class send2_package : Fragment() {

    val args: send2_packageArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSend2PackageBinding.inflate(inflater)

     
//        val take_add = args.data.toString()
//        binding.teketext.text = take_add
        binding.makepayment.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send2_package_to_transition)
        }
        binding.editPACKAGE.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send2_package_to_send_packeg_fragment)
        }

        return binding.root
    }

}