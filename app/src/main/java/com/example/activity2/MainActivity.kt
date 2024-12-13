package com.example.activity2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
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


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(countryList)
    }
}
