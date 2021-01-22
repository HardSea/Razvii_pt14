package com.example.razvii_pt14

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.razvii_pt14.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun createCountryArrayList(): ArrayList<Country> {
        val ukraine = Country("Ukraine", 603628, 41980000)
        val poland = Country("Poland", 312679, 37970000)
        val germany = Country("Germany", 357386, 83020000)
        val france = Country("France", 643801, 66990000)
        val england = Country("England", 130279, 55980000)
        val usa = Country("USA", 9834000, 328200000)
        val russia = Country("Russia", 1710000, 144500000)
        val china = Country("China", 9597000, 1393000000)
        val japan = Country("Japan", 377915, 126500000)
        val southKorea = Country("South Korea", 100210, 51640000)
        return arrayListOf(ukraine, poland, germany, france, england, usa, russia, china, japan, southKorea)
    }


    private fun setupViewPager() {
        val countryArrayList = createCountryArrayList()
        binding.viewPager.adapter = CountryViewPagerAdapter(this, countryArrayList)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = countryArrayList[position].countryName
        }.attach()

    }
}