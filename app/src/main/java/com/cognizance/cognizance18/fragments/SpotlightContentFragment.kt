package com.cognizance.cognizance18.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.R
import com.squareup.picasso.Picasso
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
        if (categoryName.equals("Lit AF"))
            Picasso.with(context).load("https://content.jdmagicbox.com/delhi/f6/011pxx11.xx11.000021915617.o7f6/logo/92216176998381152e8b24d143aa4aad.jpg").into(rajkamal)
            Picasso.with(context).load("https://cognizance.org.in/images/litaf/pustakmandi.png").into(pustakmandi)
            Picasso.with(context).load("https://cognizance.org.in/images/litaf/srishti.png").into(shrishti)
            Picasso.with(context).load("https://cognizance.org.in/images/litaf/anubhavshrivastava.jpg").into(Anubhav_Shrivastava)

    }

}
