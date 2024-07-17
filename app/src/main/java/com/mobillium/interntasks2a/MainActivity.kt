package com.mobillium.interntasks2a

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobillium.interntasks2a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonActivity.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }

        binding.buttonFragment.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
}
