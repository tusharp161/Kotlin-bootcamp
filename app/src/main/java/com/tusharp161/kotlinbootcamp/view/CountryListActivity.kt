package com.tusharp161.kotlinbootcamp.view

import android.os.Bundle
import android.util.Log
import com.tusharp161.kotlinbootcamp.base.ViewModelActivity
import com.tusharp161.kotlinbootcamp.R
import com.tusharp161.kotlinbootcamp.viewmodel.CountryListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class CountryListActivity : ViewModelActivity() {

    private val mCountryListViewModel: CountryListViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = mCountryListViewModel.getDataFromRepo()
        hello_world.text = url
        Log.d("MainActivity",url)
    }
}
