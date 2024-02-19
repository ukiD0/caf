package com.example.champ.mainPages

import android.app.ActionBar.LayoutParams
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.database.connect_db
import com.example.champ.databinding.FragmentMainScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.jan.supabase.gotrue.auth


class main_screen : Fragment() {
    lateinit var binding: FragmentMainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)
        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = true
        val db = connect_db()
        db.getClient().auth.sessionStatus.value.toString()

        val tvheader: CardView = activity!!.findViewById(R.id.cardView)
        tvheader.isVisible = false


        binding.cvChat.setOnClickListener {
            binding.cvChat.setBackgroundDrawable(resources.getDrawable(R.drawable.arrow))
            Navigation.findNavController(binding.root).navigate(R.id.action_main_screen2_to_chat)
        }

        return binding.root
    }



}