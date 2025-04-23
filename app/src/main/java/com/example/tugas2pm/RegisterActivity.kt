package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2pm.databinding.ActivityRegisterBinding

const val EXTRA_NAME = ""
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE,binding.editTextText2.text.toString())
            })
        }
    }
}