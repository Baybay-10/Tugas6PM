package com.example.tugas2pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.content.Intent
import android.widget.Button
import com.example.tugas2pm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // menjalankan animasi pada welcomeText saat di run
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        welcomeText.startAnimation(fadeIn)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtForgot.setOnClickListener{
            val intentMain = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentMain)
        }

        binding.txtRegist.setOnClickListener{
            val intentMain = Intent(this, RegisterActivity::class.java)
            startActivity(intentMain)
        }

        binding.btnLogin.setOnClickListener{
            val intentMain = Intent(this, DashboardActivity::class.java)
            startActivity(intentMain)
        }
    }
}