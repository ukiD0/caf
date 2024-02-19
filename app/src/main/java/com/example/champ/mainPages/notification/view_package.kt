package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentViewPackageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class view_package : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPackageBinding.inflate(inflater)

        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false

        val headerss: CardView = activity!!.findViewById(R.id.cardView)
        headerss.isVisible = true

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Send a package"

        val bt: ImageButton = activity!!.findViewById(R.id.bt_back)
        bt.isVisible = true

        binding.successful.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_view_package_to_successful)
        }

        return binding.root
    }

}