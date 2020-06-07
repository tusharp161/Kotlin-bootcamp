package com.tusharp161.kotlinbootcamp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmadrosid.svgloader.SvgLoader
import com.tusharp161.kotlinbootcamp.R
import com.tusharp161.kotlinbootcamp.constants.INTENT_EXTRA_COUNTRY_DETAIL
import com.tusharp161.kotlinbootcamp.constants.WIKI_URL
import com.tusharp161.kotlinbootcamp.data.network.model.CountryResponse
import com.tusharp161.kotlinbootcamp.extenstion.showError
import com.tusharp161.kotlinbootcamp.util.NetworkUtil
import kotlinx.android.synthetic.main.activity_country_detail.*
import kotlinx.android.synthetic.main.content_country_detail.*

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
        val country = getCountryFromIntent()
        setSupportActionBar(toolbar)
        setCountryDetails(country)
        fab.setOnClickListener {
            if(NetworkUtil.isNetworkAvailable(this)){
                val url = "$WIKI_URL ${country?.name}"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }else{
                this.showError(countryDetailContainer, getString(R.string.network_error_message))
            }

        }
    }

    private fun setCountryDetails(country: CountryResponse?) {
        title = country?.name
        SvgLoader.pluck()
            .with(this)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(country?.flag, countryFlag_Image)
        regionValue.text = country?.region
        subRegionValue.text = country?.subRegion
        nativeNameValue.text = country?.nativeName
        populationValue.text = country?.population.toString()
    }

    private fun getCountryFromIntent() =
        intent.getParcelableExtra<CountryResponse>(INTENT_EXTRA_COUNTRY_DETAIL)
}
