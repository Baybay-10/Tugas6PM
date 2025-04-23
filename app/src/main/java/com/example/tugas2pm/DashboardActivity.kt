package com.example.tugas2pm

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import com.example.tugas2pm.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pesan = intent.getStringExtra(EXTRA_MESSAGE)
        val textView:TextView = findViewById<TextView>(R.id.txtNama).apply {
            text =  pesan
        }

        val toolbar :  androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId){
                R.id.dashboard ->{
                    val message = binding.txtNama.text.toString() // ganti sesuai ID EditText kamu
                    val intent = Intent(this, DashboardActivity::class.java).apply {
                        putExtra(EXTRA_MESSAGE, message)
                    }
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    val message = binding.txtNama.text.toString() // ganti sesuai ID EditText kamu
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        putExtra(EXTRA_MESSAGE, message)
                    }
                    startActivity(intent)
                    true
                }
                R.id.logout -> {
                    startActivity(Intent(this,MainActivity::class.java))
                    true
                }
                else -> false
            }
        }


        // Data yang akan ditampilkan di ListView
        val list = arrayOf(
            "MOBILE LEGEND",
            "PUBG MOBILE",
            "FREE FIRE",
            "GENSHIN IMPACT",
            "HONOR OF KINGS",
            "POINT BLANK",
            "VALORANT",
        )

        // Membuat ArrayAdapter untuk menghubungkan data ke ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        // Menetapkan adapter ke ListView yang sekarang diakses melalui binding
        binding.listView.adapter = adapter

//        binding.txtKembali.setOnClickListener{
//            val intentMain = Intent(this, MainActivity::class.java)
//            startActivity(intentMain)
//        }

        binding.btnMenu.setOnClickListener{
            startActivity(Intent(this, ListActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE,binding.txtNama.text.toString())
            })
        }


        binding.listView.setOnItemClickListener { _, _, position, _ ->
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("tg://resolve?domain=DBKstorebot")))

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                // Jika Telegram tidak ada
                makeText(this, "Telegram tidak tersedia di perangkat ini", LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.logout -> {
                startActivity(Intent(this,MainActivity::class.java))
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

