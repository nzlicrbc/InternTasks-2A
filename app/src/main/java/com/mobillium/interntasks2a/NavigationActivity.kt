package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobillium.interntasks2a.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}