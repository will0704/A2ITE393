package com.example.activity2

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Country(
    val flagResId: Int,
    val name: String?,
    val capital: String?,
    val rightImage: Int?
) {

}

class CountryAdapter(private val countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagImage: ImageView = view.findViewById(R.id.flagImage)
        val countryName: TextView = view.findViewById(R.id.countryName)
        val capitalCity: TextView = view.findViewById(R.id.capitalCity)
        val rightImage: ImageView = view.findViewById(R.id.rightImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList.getOrNull(position) ?: return
        holder.countryName.text = country.name ?: "N/A"
        holder.capitalCity.text = country.capital ?: "N/A"
        holder.flagImage.setImageResource(country.flagResId)
        country.rightImage?.let { holder.rightImage.setImageResource(it) }// Set image from resource ID
    }

    override fun getItemCount() = countryList.size
}
