package com.example.champ

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.champ.databinding.ActivityBottomBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView1)
        val navHost = supportFragmentManager.findFragmentById(R.id.bottomFragmentView) as NavHostFragment
        binding.bottomNavigationView1.setupWithNavController(navHost.navController)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.main_screen,R.id.wallet2,R.id.track,R.id.profile))
        setupActionBarWithNavController(navHost.navController,appBarConfiguration)




    }
}