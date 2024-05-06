package com.example.champ.mainPages

import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.cardview.widget.CardView
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentMainScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.File


class main_screen : Fragment() {
    lateinit var binding: FragmentMainScreenBinding
    //change image from gallery
//    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
//        binding.photo.setImageURI(it)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)

        //click to changeg image from gallery
//        binding.photo.setOnClickListener {
//            galleryLauncher.launch("image/*")
//        }

        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = true

        //val db = connect_db()

        //binding.appCompatTextView21.text = db.getClient().auth.sessionStatus.value.toString()

        val tvheader: CardView = activity!!.findViewById(R.id.cardView)
        tvheader.isVisible = false


        binding.cvChat.setOnClickListener {
//            binding.cvChat.setBackgroundDrawable(resources.getDrawable(R.drawable.bl_send_a_package__1_))
            Navigation.findNavController(binding.root).navigate(R.id.action_main_screen2_to_chat)
        }


        return binding.root
    }



}