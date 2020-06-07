package com.tusharp161.kotlinbootcamp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tusharp161.kotlinbootcamp.base.ViewModelActivity
import com.tusharp161.kotlinbootcamp.R
import com.tusharp161.kotlinbootcamp.constants.INTENT_EXTRA_COUNTRY_DETAIL
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import com.tusharp161.kotlinbootcamp.extenstion.showError
import com.tusharp161.kotlinbootcamp.util.NetworkUtil
import com.tusharp161.kotlinbootcamp.viewmodel.CountryListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class CountryListActivity : ViewModelActivity(),ICountryItemClickListener {

    private val mCountryListViewModel: CountryListViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_circular.visibility = View.VISIBLE
        mCountryListViewModel.countryListLiveData.observe(this, Observer {
            processList(it)
        })
        mCountryListViewModel.errorStateLiveData.observe(this, Observer {
            showError(countryListContainer,it)
        })
        fetchCountries()
    }

    private fun fetchCountries(){
        if(NetworkUtil.isNetworkAvailable(this)){
            mCountryListViewModel.getDataFromRepo()
        }else{
            progress_circular.visibility = View.GONE
            showError(countryListContainer, getString(R.string.network_error_message),
                View.OnClickListener {
                    progress_circular.visibility = View.VISIBLE
                    fetchCountries()
                })
        }
    }

    private fun processList(it: List<CountryResponse>?) {
        val countryAdapter = CountryListRecyclerAdapter(this,this)
        countryList.layoutManager = LinearLayoutManager(this)
        countryList.adapter = countryAdapter
        countryAdapter.setData(it)
        progress_circular.visibility = View.GONE
    }

    override fun onItemClick(country: CountryResponse) {
        val intent = Intent(this,CountryDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_COUNTRY_DETAIL,country)
        startActivity(intent)
    }
}
