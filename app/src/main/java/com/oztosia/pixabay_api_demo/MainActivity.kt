package com.oztosia.pixabay_api_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.oztosia.pixabay_api_demo.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment_activity_main).navigateUp()

}