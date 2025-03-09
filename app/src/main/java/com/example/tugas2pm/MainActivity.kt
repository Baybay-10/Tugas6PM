package com.example.tugas2pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.content.Intent
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // menjalankan animasi pada welcomeText saat di run
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        welcomeText.startAnimation(fadeIn)

        val forgotPasswordLink: TextView = findViewById(R.id.textView4)
        // Menangani klik pada link Forgot Password
        forgotPasswordLink.setOnClickListener {
            // Arahkan ke halaman lupa password
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        val registrationLink: TextView = findViewById(R.id.textView7)
        // Menangani klik pada link Registration
        registrationLink.setOnClickListener{
            // Arahkan ke halaman Registrasi
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val loginLink: Button = findViewById(R.id.button)
        // Menangani klik pada link login
        loginLink.setOnClickListener{
            // Arahkan ke halaman Dashboard
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}