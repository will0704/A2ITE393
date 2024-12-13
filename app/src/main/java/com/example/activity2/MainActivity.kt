package com.example.activity2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var imageSwitcher: ImageSwitcher
    private val images = arrayOf(
        R.drawable.visitjapan,
        R.drawable.visitchina,
        R.drawable.visithongkong,
        R.drawable.visitsingapore,
        R.drawable.visitindonesia,
        R.drawable.visitturkey,
        R.drawable.visitphilippines,
        R.drawable.visitqatar,
        )

    private var currentIndex = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryList = listOf(
            Country(R.drawable.south_korea, "South Korea", "Seoul", R.drawable.plane),
            Country(R.drawable.japan, "Japan", "Tokyo", R.drawable.plane),
            Country(R.drawable.china, "China", "Beijing", R.drawable.plane),
            Country(R.drawable.singapore, "Singapore", "Singapore", R.drawable.plane),
            Country(R.drawable.thailand, "Thailand", "Bangkok", R.drawable.plane),
            Country(R.drawable.indonesia, "Indonesia", "Jakarta", R.drawable.plane),
            Country(R.drawable.malaysia, "Malaysia", "Kuala Lumpur", R.drawable.plane),
            Country(R.drawable.philippines, "Philippines", "Manila", R.drawable.plane),
            Country(R.drawable.laos, "Laos", "Vientiane", R.drawable.plane),
            Country(R.drawable.vietnam, "Vietnam", "Hanoi", R.drawable.plane),
            Country(R.drawable.lebanon, "Lebanon", "Beirut", R.drawable.plane),
            Country(R.drawable.myanmar, "Myanmar", "Naypyidaw", R.drawable.plane),
            Country(R.drawable.nepal, "Nepal", "Kathmandu", R.drawable.plane),
            Country(R.drawable.oman, "Oman", "Muscat", R.drawable.plane),
            Country(R.drawable.qatar, "Qatar", "Doha", R.drawable.plane),
            Country(R.drawable.saudi_arabia, "Saudi Arabia", "Riyadh", R.drawable.plane),
            Country(R.drawable.sri_lanka, "Sri Lanka", "Colombo", R.drawable.plane),
            Country(R.drawable.turkey, "Turkey", "Ankara", R.drawable.plane),
            Country(R.drawable.uae, "United Arab Emirates", "Abu Dhabi", R.drawable.plane),
            Country(R.drawable.kuwait, "Kuwait", "Kuwait City", R.drawable.plane)
        )

        imageSwitcher = findViewById(R.id.imageSwitcher)
        imageSwitcher.setFactory {
            ImageView(applicationContext).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
            }
        }
        imageSwitcher.setImageResource(images[currentIndex])

        // Apply animations
        imageSwitcher.inAnimation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in)
        imageSwitcher.outAnimation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_out)

        // Start automatic image switching
        startImageSwitcher()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(countryList)
    }

    private fun startImageSwitcher() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                currentIndex = (currentIndex + 1) % images.size
                imageSwitcher.setImageResource(images[currentIndex])
                handler.postDelayed(this, 5000) // Switch every 3 seconds
            }
        }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
