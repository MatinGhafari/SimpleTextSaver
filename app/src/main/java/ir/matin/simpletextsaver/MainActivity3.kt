package ir.matin.simpletextsaver
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

import ir.matin.simpletextsaver.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
 lateinit var navController:NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main3)
        Log.v("Slmbehame" ,"created")
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController=navHostFragment.navController
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(bottomNavView,navController)



}
}