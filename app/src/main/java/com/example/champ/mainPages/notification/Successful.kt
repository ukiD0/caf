package com.example.champ.mainPages.notification

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentSuccessfulBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Successful : Fragment() {
    var stars: Int = 0
    lateinit var  binding: FragmentSuccessfulBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuccessfulBinding.inflate(inflater)

        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false

        val up: CardView = activity!!.findViewById(R.id.cardView)
        up.isVisible = false

        binding.done.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_successful_to_main_screen2)
        }

        val orientationEventListener = object : OrientationEventListener(requireContext()){
            override fun onOrientationChanged(degrees: Int) {
                when(degrees){
                    50 ->{
                        addStars()
                    }
                    in 310..310 ->{
                        removeStars()
                    }
                }
            }

        }

        lifecycleScope.launch {
            binding.imgOkey.isVisible = false
            binding.header.isVisible = false
            binding.text.isVisible = false
            binding.done.isEnabled = false
            withContext(Dispatchers.IO){
                Thread.sleep(5000)
            }
            binding.header.isVisible = true
            binding.text.isVisible = true
            binding.imgOkey.visibility = View.VISIBLE
            binding.done.isEnabled = true
            orientationEventListener.enable()

        }


        return binding.root
    }

    private fun addStars(){
        if(stars in 0..4){
            val star: ImageView = requireActivity().findViewById(R.id.sddsdssds)
            star.setColorFilter(Color.YELLOW)
            stars++
        }
    }

    private fun removeStars(){
        if(stars in 1..5){
            val star: ImageView = requireActivity().findViewById(R.id.cardView)
            star.setColorFilter(Color.YELLOW)
            stars--
        }
    }

}