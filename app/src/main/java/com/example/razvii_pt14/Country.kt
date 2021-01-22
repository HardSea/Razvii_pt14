package com.example.razvii_pt14

data class Country(
        val countryName: String,
        val countryArea: Int,
        val countryPopulation: Int
) {
    val countryPopulationDensity: Int = countryPopulation / countryArea
}