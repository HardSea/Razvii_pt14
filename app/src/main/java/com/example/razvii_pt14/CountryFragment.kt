package com.example.razvii_pt14

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import com.example.razvii_pt14.databinding.CountryFragmentBinding

    class CountryFragment : Fragment() {


        private lateinit var binding: CountryFragmentBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = CountryFragmentBinding.inflate(inflater, container, false)
            val position = this.arguments?.get("position")
            binding.textView.text = position.toString()
            return binding.root
        }

        companion object {
            fun newInstance(position: Int): CountryFragment {
                val args = Bundle()
                args.putInt("position", position)

                val fragment = CountryFragment()
                fragment.arguments = args
                return fragment
            }

        }
    }