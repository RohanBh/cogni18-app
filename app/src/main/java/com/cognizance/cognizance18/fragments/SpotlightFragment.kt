package com.cognizance.cognizance18.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener
import kotlinx.android.synthetic.main.fragment_spotlight.*

class SpotlightFragment : Fragment() {

    private lateinit var mListener: OnFragmentAddedListener

    companion object {

        const val TECHTAINMENT_TAG = "techtainment_fragment"
        const val GUEST_SPEAKERS_TAG = "guest_speakers_fragment"

        @JvmStatic
        fun newInstance(): SpotlightFragment {
            return SpotlightFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as? OnFragmentAddedListener ?: throw ClassCastException("$context must implement OnFragmentAddedListener")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_spotlight, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        techtainment_tab.performClick()
        mListener.onFragmentAdd(3)
    }

    private fun changeTab(selectedTab: TextView, otherTab: TextView, fragmentTag: String) {
        selectedTab.isSelected = true
        selectedTab.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        otherTab.isSelected = false
        otherTab.setTextColor(ResourcesCompat.getColor(resources, R.color.dark_gray, null))

        val fragmentManager = childFragmentManager
        val selectedFragment = fragmentManager.findFragmentByTag(fragmentTag)
                ?: SpotlightContentFragment.newInstance(selectedTab.text.toString())

        fragmentManager.beginTransaction()
                .replace(R.id.container, selectedFragment, fragmentTag)
                .addToBackStack(null)
                .commit()
    }

}
