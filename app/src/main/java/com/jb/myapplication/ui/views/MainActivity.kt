package com.jb.myapplication.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.jb.myapplication.R
import com.jb.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity,drawer,R.string.open,R.string.close)
            drawer.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navBar.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.all_matches -> {
                        supportFragmentManager.beginTransaction().replace(R.id.container, AllMatchesFragment()).commit()

                    }
                    R.id.saved_matches -> {
                        supportFragmentManager.beginTransaction().replace(R.id.container, SavedMatchesFragment()).commit()

                    }

                }
                true
            }
        }

/*        binding.apply {
            tvAllMatches.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.container, AllMatchesFragment()).commit()
            }
            tvSavedMatches.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.container, SavedMatchesFragment()).commit()

            }

        }*/


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}