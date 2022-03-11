package com.o3interfaces.payanyonetask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            bottomNavigation.selectedItemId = R.id.miPayment
            ivArrow.setOnClickListener {
                onBackPressed()
            }
        }
    }
}