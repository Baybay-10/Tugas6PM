package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2pm.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.jvm.internal.Ref.IntRef

const val EXTRA_NAME = ""
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()

        binding.btnSimpan.setOnClickListener{
            val username : String = binding.edtUsername.text.toString().trim()
            val email :String = binding.edtEmail.text.toString().trim()
            val password : String = binding.edtPass.text.toString().trim()
            val confPass : String = binding.edtConfirmPass.text.toString().trim()

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

            if(password != confPass){
                binding.edtPass.error = "password harus sama"
                binding.edtPass.requestFocus()
                return@setOnClickListener
            }
            registerUser(email,password)
        }
    }
    private fun registerUser(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            if(it.isSuccessful){
                Intent(this,DashboardActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else{
                Toast.makeText(this,it.exception?.message,Toast.LENGTH_SHORT).show()
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