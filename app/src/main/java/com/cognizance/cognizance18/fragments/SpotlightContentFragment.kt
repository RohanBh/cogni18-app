package com.cognizance.cognizance18.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.Services.DataServices
import com.cognizance.cognizance18.adapters.SpotLightRVIewAdapterj
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
            Log.d("LOLOLO", "" + fragment.arguments)
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
        if (categoryName.equals("Guest Speakers"))
            spotlight_recycler_view.adapter = SpotLightRVIewAdapterj(context, DataServices.techtainments)
        else if (categoryName.equals("Techtainment"))
            spotlight_recycler_view.adapter = SpotLightRVIewAdapterj(context, DataServices.techtainments)

        spotlight_recycler_view.layoutManager = LinearLayoutManager(activity)
    }

}
