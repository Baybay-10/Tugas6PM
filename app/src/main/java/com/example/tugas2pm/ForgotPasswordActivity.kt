package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.widget.Button
import com.example.tugas2pm.databinding.ActivityForgotPasswordBinding


class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        welcomeText.startAnimation(fadeIn)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener{
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}