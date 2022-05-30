package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.R
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? NavHostFragment)?.let {
            NavigationUI.setupWithNavController(
                binding.bottomNavigation,
                it.navController
            )
        }
    }
}