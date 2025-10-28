package com.example.livrostore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.livrostore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Configurar navegação
        setupNavigation()
    }
    
    private fun setupNavigation() {
        // Pegar o NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        
        // Pegar o NavController
        val navController = navHostFragment.navController
        
        // Conectar o BottomNavigation com o NavController
        binding.bottomNavigation.setupWithNavController(navController)
    }
}
