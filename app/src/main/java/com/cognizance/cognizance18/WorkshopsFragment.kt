package com.cognizance.cognizance18

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_workshops.*

class WorkshopsFragment : Fragment() {

    private val mEventList by lazy {
        //generateFakeData()
    }

    companion object {
        @JvmStatic
        fun newInstance(): WorkshopsFragment {
            return WorkshopsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflater?.inflate(R.layout.fragment_workshops, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //workshops_recycler_view.adapter = WorkshopsRViewAdapter(mEventList)
        workshops_recycler_view.layoutManager = LinearLayoutManager(context)
    }

    /*private fun generateFakeData() = List<Event>(10) {
        Event("Fake Event ${it + 1}", getString(R.string.placeholder_text), "24-25 March 2018")
    }*/


}
