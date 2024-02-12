package com.example.champ.login

import android.app.PendingIntent.OnFinished
import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentOTPverifBinding

class OTPverif : Fragment() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOTPverifBinding.inflate(inflater)

        binding.sendOTP.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_OTPverif_to_newPassword)
        }

        var time = 60
        val timer = object: CountDownTimer(60000, 1000) {
        override fun onTick(millisUntilFinished: Long) =
            run {
                time--
                if(time <= 0){
                    cancel()
                    binding.sendOTP.isEnabled = false
                    binding.timer.text = "resend"
                    binding.timer.isEnabled = true
                    time = 60
                }else{
                    binding.timer.text = "$time"
                }
            }
            override fun onFinish() = Unit
        }
        binding.timer.setOnClickListener{
            timer.start()
            binding.timer.isEnabled = false
       }
        timer.start()


        return binding.root
    }

}