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
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.champ.R
import com.example.champ.database.connect_db
import com.example.champ.databinding.FragmentMainScreenBinding
import io.github.jan.supabase.gotrue.auth


class main_screen : Fragment() {
    var stars: Int = 0
    lateinit var binding: FragmentMainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)

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

        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Home"


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