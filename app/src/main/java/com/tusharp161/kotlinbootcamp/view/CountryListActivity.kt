package com.tusharp161.kotlinbootcamp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.tusharp161.kotlinbootcamp.base.ViewModelActivity
import com.tusharp161.kotlinbootcamp.R
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import com.tusharp161.kotlinbootcamp.viewmodel.CountryListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class CountryListActivity : ViewModelActivity(),ICountryItemClickListener {

    private val mCountryListViewModel: CountryListViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCountryListViewModel.countryListLiveData.observe(this, Observer {
            processList(it)
        })
        mCountryListViewModel.getDataFromRepo()
    }

    private fun processList(it: List<CountryResponse>?) {
        val countryAdapter = CountryListRecyclerAdapter(this,this)
        countryList.layoutManager = LinearLayoutManager(this)
        countryList.adapter = countryAdapter
        countryAdapter.setData(it)
    }

    override fun onItemClick(country: CountryResponse) {
        val intent = Intent(this,CountryDetailActivity::class.java)
            intent.putExtra("CountryData",country)
        startActivity(intent)
    }
}
