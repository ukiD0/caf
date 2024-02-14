package com.example.champ.mainPages.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentSendPackegFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class send_packeg_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSendPackegFragmentBinding.inflate(inflater)

        val maintext: TextView = activity!!.findViewById(R.id.tvheader)
        maintext.text = "Send a package"

        val arrow: ImageButton = activity!!.findViewById(R.id.bt_back)
        arrow.isVisible = true
        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = false

        val address = binding.firstAdd.text.toString()
        val country = binding.country.text.toString()
        val phone = binding.phonenumber.text.toString()

        val all = arrayListOf<String>(country,phone)

//        binding.instatDel.setOnClickListener {
//            val action = send_packeg_fragmentDirections.actionSendPackegFragmentToSend2Package(address.toString())
////            action.data = address
////            all.toTypedArray()
//            Navigation.findNavController(binding.instatDel).navigate(action)
//        }
        binding.instatDel.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send_packeg_fragment_to_send2_package)
        }


        return binding.root
    }


}