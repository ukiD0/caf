package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.champ.R
import com.example.champ.databinding.FragmentAddPaymentFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class add_payment_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddPaymentFragmentBinding.inflate(inflater)
        val bt: ImageButton = activity!!.findViewById(R.id.bt_back)
        bt.isVisible  = true
        val tvheader: TextView = activity!!.findViewById(R.id.tvheader)
        tvheader.text = "Add Payment Method"
        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false

        //кнопочки
        binding.rb2.setOnClickListener{
            binding.cards.visibility = View.VISIBLE
            binding.radioButton.isChecked = false
        }
        binding.radioButton.setOnClickListener {
            binding.rb2.isChecked = false
            binding.cards.visibility = View.GONE
        }
        binding.rb3.setOnClickListener{
            binding.rb4.isChecked = false
        }
        binding.rb4.setOnClickListener{
            binding.rb3.isChecked = false
        }


        return binding.root
    }

}