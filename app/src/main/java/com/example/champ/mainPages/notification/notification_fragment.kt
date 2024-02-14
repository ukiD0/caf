package com.example.champ.mainPages.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.champ.BottomActivity
import com.example.champ.R
import com.example.champ.databinding.ActivityBottomBinding
import com.example.champ.databinding.FragmentNotificationFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class notification_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNotificationFragmentBinding.inflate(inflater)

        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false

        val btBack: ImageButton = activity!!.findViewById(R.id.bt_back)
        btBack.isVisible = true

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Notification"



        return binding.root
    }

}