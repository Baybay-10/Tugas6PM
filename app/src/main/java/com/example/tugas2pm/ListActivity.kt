package com.example.tugas2pm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas2pm.databinding.ActivityDashboardBinding
import com.example.tugas2pm.databinding.ActivityListBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListBinding
    private lateinit var produkRecyclerView: RecyclerView
    private lateinit var produkAdapter: MyAdapter
    private lateinit var listProduk : ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pesan = intent.getStringExtra(EXTRA_MESSAGE)
        val textView: TextView = findViewById<TextView>(R.id.txtNama).apply {
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


        listProduk = ArrayList()

        listProduk.add(
            ItemData(
                R.drawable.ml,
                "Mobile Legends",
                "Mobile Legends: Bang Bang adalah game MOBA 5v5 yang dimainkan secara online lewat Android dan iOS." +
                        "Pemain memilih hero dengan role berbeda seperti Tank, Mage, atau Assassin untuk bertarung dalam tim dan menghancurkan base lawan." +
                        "Game ini populer karena gameplay cepat, grafis menarik, dan komunitas esports yang besar."))
        listProduk.add(
            ItemData(
                R.drawable.ff,
                "Free Fire",
                "Free Fire adalah game battle royale yang dikembangkan oleh Garena untuk Android dan iOS. " +
                        "Dalam game ini, 50 pemain diterjunkan ke sebuah pulau dan bertarung hingga tersisa satu pemain atau tim terakhir. " +
                        "Pemain harus mencari senjata, perlengkapan, dan strategi bertahan hidup di zona yang terus menyempit. Dengan durasi pertandingan yang singkat dan gameplay yang intens, " +
                        "Free Fire jadi salah satu game mobile terpopuler di dunia, khususnya di Asia dan Amerika Latin."))
        listProduk.add(
            ItemData(
                R.drawable.valorant,
                "Valorant",
                "Valorant adalah game tactical shooter 5v5 berbasis tim yang dikembangkan oleh Riot Games untuk PC." +
                        "Dalam game ini, pemain memilih karakter yang disebut Agent, masing-masing dengan kemampuan unik, dan bertarung dalam mode penanaman bom seperti di game klasik Counter-Strike," +
                        "namun dengan sentuhan skill ala hero shooter. Valorant menuntut akurasi, strategi, dan kerja sama tim yang solid. " +
                        "Dengan grafis keren dan kompetisi esports yang besar, Valorant jadi salah satu game FPS paling populer saat ini."))
        listProduk.add(
            ItemData(
                R.drawable.pubg,
                "PUBG MOBILE",
                "PUBG Mobile adalah game battle royale yang dikembangkan oleh Tencent Games. Dalam game ini, 100 pemain diterjunkan ke sebuah pulau untuk bertahan hidup dan menjadi yang terakhir. " +
                        "Pemain harus mencari senjata, kendaraan, dan perlengkapan, sambil menghindari zona yang terus menyusut. " +
                        "Dengan grafis realistis dan gameplay menegangkan, PUBG Mobile jadi salah satu game mobile paling populer di dunia."))
        listProduk.add(
            ItemData(
            R.drawable.hok,
                "Honor Of Kings",
                "Honor of Kings adalah game MOBA 5v5 yang dikembangkan oleh TiMi Studio dan diterbitkan oleh Tencent Games. " +
                        "Game ini mirip dengan Mobile Legends, di mana pemain memilih hero dengan skill unik untuk bertarung dalam tim dan menghancurkan base lawan. " +
                        "Dengan grafis memukau, gameplay kompetitif, dan pilihan hero yang beragam, Honor of Kings menjadi salah satu game mobile paling populer di dunia, terutama di Tiongkok dan kini mulai merambah pasar global."))
        listProduk.add(
            ItemData(
                R.drawable.gi,
                "Genshin Impact",
                "Genshin Impact adalah game RPG open-world yang dikembangkan oleh HoYoverse. Pemain menjelajahi dunia fantasi bernama Teyvat, bertarung dengan elemen, menyelesaikan quest, dan mengumpulkan karakter dengan skill unik. " +
                        "Dengan grafis indah, cerita mendalam, dan sistem pertarungan berbasis elemen, Genshin Impact jadi salah satu game RPG mobile dan PC paling populer secara global."))
        listProduk.add(
            ItemData(
                R.drawable.pb,
                "Point Blank",
                "Point Blank adalah game FPS (First-Person Shooter) online yang dikembangkan oleh Zepetto. Dalam game ini, dua tim — Free Rebels dan CT-Force — bertarung dalam berbagai mode seperti bomb mission, deathmatch, dan lainnya. " +
                        "Point Blank terkenal dengan gameplay cepat, senjata beragam, serta sistem karakter dan clan yang seru. Game ini sempat jadi salah satu FPS paling populer di warnet Indonesia."))
        listProduk.add(
            ItemData(
                R.drawable.codm,
                "Call Of Duty Mobile",
                "Call of Duty: Mobile adalah game FPS yang dikembangkan oleh TiMi Studio dan diterbitkan oleh Activision. Game ini menggabungkan mode klasik seperti Team Deathmatch, Search & Destroy, hingga Battle Royale, lengkap dengan berbagai map ikonik dari seri Call of Duty. " +
                        "Dengan grafis tinggi, kontrol responsif, dan gameplay kompetitif, CoD Mobile menjadi salah satu game tembak-tembakan terbaik di platform mobile."))

        produkRecyclerView = findViewById(R.id.daftarProduct)
        produkRecyclerView.setHasFixedSize(true)
        produkRecyclerView.layoutManager = LinearLayoutManager(this)

        produkAdapter =MyAdapter(listProduk)
        produkRecyclerView.adapter = produkAdapter
        produkAdapter.onItemClick = {
            val intent = Intent(this,DetailProductActivity::class.java)
            intent.putExtra("product",it)
            startActivity(intent)
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