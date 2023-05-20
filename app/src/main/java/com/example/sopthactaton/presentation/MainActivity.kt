package com.example.sopthactaton.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.sopthactaton.R
import com.example.sopthactaton.presentation.home.TestViewModel
import com.example.sopthactaton.util.ViewModelFactory

class MainActivity : AppCompatActivity() {
    /**
     * activity
     * private val viewModel: TestViewModel by viewModels { ViewModelFactory(this) }
     * fragment
     * private val viewModel: TestViewModel by viewModels { ViewModelFactory(requireContext()) }
     * **/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navigationFragment =
//            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
//        val navController = navigationFragment.navController
//        NavigationUI.setupWithNavController(binding.mainBottomNavigation, navController)
//        binding.mainBottomNavigation.setOnItemReselectedListener { }
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.navigation_1 || destination.id == R.id.navigation_2 || destination.id == R.id.navigation_3)
//                binding.mainBottomNavigation.visibility = View.VISIBLE
//            else
//                binding.mainBottomNavigation.visibility = View.GONE
//        }
    }
}