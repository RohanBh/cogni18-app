package com.cognizance.cognizance18

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.adapters.WorkshopsRViewAdapter
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener
import com.cognizance.cognizance18.models.Event
import kotlinx.android.synthetic.main.fragment_workshops.*

class WorkshopsFragment : Fragment() {

    private lateinit var mListener : OnFragmentAddedListener

    private val mEventList by lazy {
        generateFakeData()
    }

    companion object {
        @JvmStatic
        fun newInstance(): WorkshopsFragment {
            return WorkshopsFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as? OnFragmentAddedListener ?:
                throw ClassCastException("$context must implement OnFragmentAddedListener")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_workshops, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workshops_recycler_view.adapter = WorkshopsRViewAdapter(mEventList)
        workshops_recycler_view.layoutManager = LinearLayoutManager(context)
        mListener.onFragmentAdd(1)
    }

    private fun generateFakeData() = List<Event>(10) {
        Event("Fake Event ${it + 1}", getString(R.string.placeholder_text), "24-25 March 2018")
    }


}
