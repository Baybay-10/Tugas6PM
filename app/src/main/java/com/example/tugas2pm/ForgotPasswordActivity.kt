package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import com.example.tugas2pm.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth


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

        binding.btnContinue.setOnClickListener {
            val email: String = binding.edtEmail.text.toString().trim()
            if (email.isEmpty()){
                binding.edtEmail.error = "Input email"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmail.error = "Invalid email"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this,"Cek Email Untuk Reset Password",Toast.LENGTH_SHORT).show()
                    Intent(this,MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else{
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}