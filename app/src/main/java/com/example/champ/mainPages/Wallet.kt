package com.example.champ.mainPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.champ.R
import com.example.champ.databinding.FragmentWalletBinding


class Wallet : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWalletBinding.inflate(inflater)

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Wallet"


        return binding.root
    }


}