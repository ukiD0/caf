package com.example.champ.onBoarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
//            if(onBoardindFinished()){
//                if(onLoginFinished()){
//                    var db = connect_db()
//                    var client = db.getClient()
//                    Log.e("test", client.auth.currentAccessTokenOrNull().toString())
//                    val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
//                    var email1 = sharedPref.getString("email", "")
//                    var pass = sharedPref.getString("password", "")
//                    lifecycleScope.launch {
//                        try {
//                            client.auth.signInWith(Email){
//                                email = email1.toString()
//                                password = pass.toString()
//                            }
//                        }catch (e: Exception){
//                            Log.e("error", e.message.toString())
//                        }
//
//                    }
//                    findNavController().navigate(R.id.action_splash_screen_to_bottomActivity)
//                    Log.e("error", email1.toString())
//                    requireActivity().finish()
//                }else{
//                    findNavController().navigate(R.id.action_splash_screen_to_homeFragment)
//                }
//            }else{
                findNavController().navigate(R.id.action_splash_screen_to_viewPagerFragmnet)
//            }
        },500)
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