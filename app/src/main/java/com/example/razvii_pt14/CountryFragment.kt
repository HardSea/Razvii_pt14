package com.example.razvii_pt14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.razvii_pt14.databinding.CountryFragmentBinding
import java.text.DecimalFormat

private const val ARG_PARAM_COUNTRY_NAME = "country_name"
private const val ARG_PARAM_COUNTRY_AREA = "country_population"
private const val ARG_PARAM_COUNTRY_POPULATION = "country_area"
private const val ARG_PARAM_COUNTRY_POPULATION_DENSITY = "country_population_density"

class CountryFragment : Fragment() {


    private lateinit var binding: CountryFragmentBinding

    private var countryName: String? = null
    private var countryArea: Int? = null
    private var countryPopulation: Int? = null
    private var countryPopulationDensity: Int? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = CountryFragmentBinding.inflate(inflater, container, false)
        setViews()
        return binding.root
    }

    private fun setViews() {
        binding.tvCountryName.text = getString(R.string.country_name_text, countryName)
        val decFormat = DecimalFormat("###,###,###")
        binding.tvCountryArea.text = getString(R.string.country_area_text, decFormat.format(countryArea))
        binding.tvCountryPopulation.text = getString(R.string.country_population_text, decFormat.format(countryPopulation))
        binding.tvCountryPopulationDensity.text = getString(R.string.country_population_density_text, countryPopulationDensity)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            countryName = it.getString(ARG_PARAM_COUNTRY_NAME)
            countryArea = it.getInt(ARG_PARAM_COUNTRY_AREA)
            countryPopulation = it.getInt(ARG_PARAM_COUNTRY_POPULATION)
            countryPopulationDensity = it.getInt(ARG_PARAM_COUNTRY_POPULATION_DENSITY)
        }
    }

    companion object {

        fun newInstance(country: Country): CountryFragment {
            val args = Bundle()
            args.putString(ARG_PARAM_COUNTRY_NAME, country.countryName)
            args.putInt(ARG_PARAM_COUNTRY_POPULATION, country.countryPopulation)
            args.putInt(ARG_PARAM_COUNTRY_AREA, country.countryArea)
            args.putInt(ARG_PARAM_COUNTRY_POPULATION_DENSITY, country.countryPopulationDensity)
            val fragment = CountryFragment()
            fragment.arguments = args
            return fragment
        }

    }
}