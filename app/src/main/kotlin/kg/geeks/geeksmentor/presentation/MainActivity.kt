package kg.geeks.geeksmentor.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.geeks.geeksmentor.R
import kg.geeks.geeksmentor.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
//    private lateinit var pref: Pref
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.onBoardFragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
        val bottomNavFragments = arrayListOf(
            R.id.navigation_home,
            R.id.navigation_search,
            R.id.navigation_profile
        )
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            navView.isVisible = bottomNavFragments.contains(destination.id)
            if (destination.id == R.id.onBoardFragment) {
                window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            } else {
                window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            }
        }
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        if (navController.currentDestination?.id == R.id.navigation_home) {
            finish() // Выход из активити или приложения, только если текущий фрагмент - navigation_home
        } else {
            super.onBackPressed() // Обычное поведение кнопки "Назад" для других фрагментов
        }
    }
}
