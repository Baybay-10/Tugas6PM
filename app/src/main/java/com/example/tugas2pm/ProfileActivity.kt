package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2pm.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup ViewBinding
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val pesan = intent.getStringExtra(EXTRA_MESSAGE)

        val textView: TextView = findViewById<TextView>(R.id.txtNama).apply {
            text =  pesan
        }

        // Data untuk list view
        val list = listOf("Mobile Legends",
            "PUBG Mobile",
            "Genshin Impact",
            "Free Fire")

        // Membuat ArrayAdapter dan menghubungkan data ke ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        binding.listView.adapter = adapter

        // Setup ImageView Profil
        val imageView = binding.imageView4
        imageView.setImageResource(R.drawable.foto)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)

        // Setup BottomNavigationView
        binding.bottomNavigation.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.dashboard ->{
                    val message = binding.txtNama.text.toString() // ganti sesuai ID EditText kamu
                    val intent = Intent(this, DashboardActivity::class.java).apply {
                        putExtra(EXTRA_MESSAGE, message)
                    }
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    val message = binding.txtNama.text.toString() // ganti sesuai ID EditText
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        putExtra(EXTRA_MESSAGE, message)
                    }
                    startActivity(intent)
                    true
                }
                R.id.logout -> {
                    auth.signOut()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                auth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
                return true
            }
            R.id.profile -> {
                val message = binding.txtNama.text.toString() // ganti sesuai ID EditText kamu
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                startActivity(intent)
                return true
            }
            R.id.dashboard -> {
                val message = binding.txtNama.text.toString() // ganti sesuai ID EditText kamu
                val intent = Intent(this, DashboardActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
