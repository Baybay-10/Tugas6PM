package com.example.tugas2pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.content.Intent
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugas2pm.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

const val EXTRA_MESSAGE = ""
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firebaseAuth=FirebaseAuth.getInstance()

        // menjalankan animasi welcomeText saat di run
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        welcomeText.startAnimation(fadeIn)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val email :String = binding.edtEmail.text.toString().trim()
            val password : String = binding.edtPass.text.toString().trim()

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

            if (password.isEmpty() || password.length <6){
                binding.edtPass.error = "Password minimal 6 character"
                binding.edtPass.requestFocus()
                return@setOnClickListener
            }
            loginUser(email,password)
        }
        binding.txtForgot.setOnClickListener{
            val intentMain = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentMain)
        }

        binding.txtRegist.setOnClickListener{
            val intentMain = Intent(this, RegisterActivity::class.java)
            startActivity(intentMain)
        }
    }
    private fun loginUser(email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if(it.isSuccessful){
                Intent(this,DashboardActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else{
                Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null){
            Intent(this, DashboardActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}