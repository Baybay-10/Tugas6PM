package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        // Mendapatkan referensi ListView dari XML
        val listView: ListView = findViewById(R.id.listView)

        // Data yang akan ditampilkan di dalam ListView
        val taskList = arrayOf(
            "Task 1 - Belajar Kotlin",
            "Task 2 - Kerjakan project",
            "Task 3 - Menyusun laporan",
            "Task 4 - Baca buku Android Studio",
            "Task 5 - Review kode",
            "Task 6 - Mengumpulkan Tugas"
        )

        // Membuat ArrayAdapter untuk menghubungkan data ke ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        // Menetapkan adapter ke ListView
        listView.adapter = adapter

        val kembaliLink: TextView = findViewById(R.id.textView11)
        // Menangani klik pada link Kembali
        kembaliLink.setOnClickListener {
            // Arahkan ke halaman Login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}