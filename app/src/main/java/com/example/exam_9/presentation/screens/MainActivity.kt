package com.example.exam_9.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.exam_9.R
import com.example.exam_9.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    if (navController.currentDestination?.id != R.id.home) {
                        navController.navigate(R.id.homeFragment)
                    }
                    true
                }

                R.id.notifications -> {
                    if (navController.currentDestination?.id != R.id.notifications) {
                        navController.navigate(R.id.notificationsFragment)
                    }
                    true
                }

                R.id.favorites -> {
                    if (navController.currentDestination?.id != R.id.favorites) {
                        navController.navigate(R.id.favoritesFragment)
                    }
                    true
                }
                else -> false
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

            with(binding.bottomNavigationView) {
                when (destination.id) {
                    R.id.homeFragment -> selectedItemId = R.id.homeFragment
                    R.id.notifications -> selectedItemId = R.id.notificationsFragment
                    R.id.favorites -> selectedItemId = R.id.favoritesFragment
                }
            }
        }
    }


}