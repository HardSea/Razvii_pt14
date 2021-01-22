package com.example.razvii_pt14

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CountryViewPagerAdapter(activity: AppCompatActivity, private val countryList: ArrayList<Country>) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun createFragment(position: Int): Fragment {
        return CountryFragment.newInstance(countryList[position])
    }

}