package com.tusharp161.kotlinbootcamp.view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.tusharp161.kotlinbootcamp.R
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import kotlinx.android.synthetic.main.list_item_country.view.*

class CountryListRecyclerAdapter(val context: Context,val listener:ICountryItemClickListener) :
    RecyclerView.Adapter<CountryListRecyclerAdapter.CountryViewHolder>() {

    var country: List<CountryResponse>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_country, parent, false),listener
        )
    }

    override fun getItemCount(): Int = country!!.size

    override fun onBindViewHolder(contryViewHolder: CountryViewHolder, position: Int) {
        contryViewHolder.bindView(context,country!![position])

    }

    fun setData(country: List<CountryResponse>?) {
        this.country = country;
    }

    class CountryViewHolder(itemView: View,val listener: ICountryItemClickListener) : RecyclerView.ViewHolder(itemView){
        fun bindView(context: Context,country:CountryResponse){
            itemView.countryName.text = country.name
            SvgLoader.pluck()
                .with(context as Activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(country.flag, itemView.countryFlag)
            itemView.setOnClickListener {
                listener.onItemClick(country)
            }
        }
    }
}