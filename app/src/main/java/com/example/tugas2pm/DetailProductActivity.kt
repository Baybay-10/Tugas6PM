package com.example.tugas2pm

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_product)


        val product = intent.getParcelableExtra<ItemData>("product")
        if(product != null){
            val imageView: ImageView = findViewById(R.id.imageView3)
            val textViewTitle: TextView = findViewById(R.id.imageTitle)
            val textViewDesc: TextView = findViewById(R.id.imageDesc)

            imageView.setImageResource(product.gambar)
            textViewTitle.text = product.nama
            textViewDesc.text = product.Desc
        }
    }

}