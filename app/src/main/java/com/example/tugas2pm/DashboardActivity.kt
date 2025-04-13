package com.example.tugas2pm

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.*
import com.example.tugas2pm.databinding.ActivityDashboardBinding



class DashboardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data yang akan ditampilkan di ListView
        val list = arrayOf(
            "PULSA",
            "TOKEN LISTRIK",
            "TOP UP E-WALLET",
            "TOP UP GAME",
            "VOUCHER",
            "TAGIHAN",
        )


        // Membuat ArrayAdapter untuk menghubungkan data ke ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        // Menetapkan adapter ke ListView yang sekarang diakses melalui binding
        binding.listView.adapter = adapter

        binding.txtKembali.setOnClickListener{
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }

        binding.btnMenu.setOnClickListener{
            val intentMain = Intent(this, ListActivity::class.java)
            startActivity(intentMain)
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
}

