package com.example.champ.mainPages

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.champ.R
import com.example.champ.database.connect_db
import com.example.champ.databinding.FragmentMainScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.jan.supabase.gotrue.auth


class main_screen : Fragment() {
    var stars: Int = 0
    lateinit var binding: FragmentMainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        val db = connect_db()
        val orientationEventListener = object : OrientationEventListener(requireContext()) {
            override fun onOrientationChanged(orientation: Int) {
                when (orientation) {
                    in 50..50 -> {
                        addStars()
                        //Toast.makeText(requireContext(), orientation.toString(), Toast.LENGTH_LONG).show()
                    }
                    in 310..310 -> {
                        removeStars()
                        //Toast.makeText(requireContext(), orientation.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        orientationEventListener.enable()


        db.getClient().auth.sessionStatus.value.toString()
        return binding.root
    }

    private fun removeStars() {
        if (stars in 1 .. 5){
            stars--
            val star:ImageView = binding.layoutStar.getChildAt(stars) as ImageView
            star.setColorFilter(ContextCompat.getColor(requireContext(), R.color.text_gray_color))
        }
    }

    private fun addStars() {
        if (stars in 0..4){
            val star:ImageView = binding.layoutStar.getChildAt(stars) as ImageView
            star.setColorFilter(Color.YELLOW)
            stars++
        }
    }


}