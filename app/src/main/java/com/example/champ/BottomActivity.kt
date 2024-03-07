package com.example.champ

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.champ.databinding.ActivityBottomBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomBinding
    public lateinit var btBack: ImageButton
    public  lateinit var tvheader: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btBack = binding.btBack
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView1)
        val navHost = supportFragmentManager.findFragmentById(R.id.bottomFragmentView) as NavHostFragment
        binding.bottomNavigationView1.setupWithNavController(navHost.navController)

        binding.btBack.isVisible = false
        binding.cardView.isVisible = true

        btBack.setOnClickListener {
            navHost.navController.popBackStack()
        }



    }
}