package com.example.tugas2pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas2pm.databinding.ActivityDashboardBinding
import com.example.tugas2pm.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var produkRecyclerView: RecyclerView
    private lateinit var produkAdapter: MyAdapter
    private lateinit var listProduk : ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        produkRecyclerView = findViewById(R.id.daftarProduct)
        listProduk = ArrayList()

        listProduk.add(ItemData(R.drawable.ml,"Mobile Legends","Rp. : 1.500 - 2.000.000"))
        listProduk.add(ItemData(R.drawable.ff,"Free Fire","Rp. : 1.000 - 1.500.000"))
        listProduk.add(ItemData(R.drawable.valorant,"Valorant","Rp. : 45.000 - 1.500.000"))
        listProduk.add(ItemData(R.drawable.pubg,"PUBG MOBILE","Rp. : 1.500 - 2.000.000"))
        listProduk.add(ItemData(R.drawable.hok,"Honor Of Kings","Rp. : 1.500 - 2.000.000"))
        listProduk.add(ItemData(R.drawable.pulsa,"Pulsa Telkomsel","Rp. : 6.000 - 200.000"))
        listProduk.add(ItemData(R.drawable.pln,"Token Listrik","Rp. : 21.000 - 1.010.000"))
        listProduk.add(ItemData(R.drawable.ewallet,"E-Wallet","Rp. : 6,000 - 1.010.000"))

        produkRecyclerView.layoutManager = LinearLayoutManager(this)
        produkRecyclerView.setHasFixedSize(true)
        produkAdapter =MyAdapter(listProduk)
        produkRecyclerView.adapter = produkAdapter
    }
}