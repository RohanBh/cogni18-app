package com.cognizance.cognizance18.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.adapters.SpotLightRViewAdapter
import com.cognizance.cognizance18.models.SpotLight
import kotlinx.android.synthetic.main.fragment_spotlight_content.*

class SpotlightContentFragment : Fragment() {

    private lateinit var categoryName: String

    companion object {
        @JvmStatic
        fun newInstance(categoryName: String): SpotlightContentFragment {
            val fragment = SpotlightContentFragment()
            fragment.arguments = Bundle().apply {
                putString("category", categoryName)
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryName = arguments?.getString("category") ?: "Spotlight"
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_spotlight_content, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spotlight_recycler_view.adapter = SpotLightRViewAdapter(List<SpotLight>(25) {
            SpotLight("$categoryName ${it + 1}")
        })
        spotlight_recycler_view.layoutManager = GridLayoutManager(activity, 3)
    }

}
