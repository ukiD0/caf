package com.example.champ.mainPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.champ.R
import com.example.champ.databinding.FragmentTrackBinding


class Track : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTrackBinding.inflate(inflater)

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Track"


        return binding.root
    }

}