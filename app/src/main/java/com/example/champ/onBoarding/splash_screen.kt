package com.example.champ.onBoarding

import android.app.PendingIntent.OnFinished
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.champ.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class splash_screen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler(Looper.getMainLooper()).postDelayed({
            if(onBoardindFinished()){
                if(onLoginFinished()){
                    findNavController().navigate(R.id.action_splash_screen_to_bottomActivity)
                    requireActivity().finish()
                }else{
                    findNavController().navigate(R.id.action_splash_screen_to_homeFragment)
                }
            }else{
                findNavController().navigate(R.id.action_splash_screen_to_viewPagerFragmnet)
            }
        },2500)
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }


    private fun onBoardindFinished():Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
    private fun onLoginFinished():Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("isLogin",false)
    }

}