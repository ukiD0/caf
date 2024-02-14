package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.example.champ.R
import com.example.champ.databinding.FragmentSuccessfulBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Successful : Fragment() {
    var stars: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuccessfulBinding.inflate(inflater)
        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false
        val header: CardView = activity!!.findViewById(R.id.cardView)
        header.isVisible = false

        val OrientationEventListener = object: OrientationEventListener(requireContext()){
            override fun onOrientationChanged(p0: Int) {
                TODO("Not yet implemented")
            }
        }


        return binding.root
    }

}