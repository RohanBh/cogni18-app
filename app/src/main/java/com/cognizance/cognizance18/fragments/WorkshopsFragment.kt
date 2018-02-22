package com.cognizance.cognizance18.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.SessionManager
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener
import com.cognizance.cognizance18.models.Workshop
import com.cognizance.cognizance18.models.WorkshopList
import com.cognizance.cognizance18.utilities.getInterfaceService
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_workshops.*
import kotlinx.android.synthetic.main.item_carousels.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WorkshopsFragment : Fragment() {

    private lateinit var mListener: OnFragmentAddedListener
    private lateinit var session: SessionManager
    private val realm = Realm.getDefaultInstance()

    companion object {
        @JvmStatic
        fun newInstance(): WorkshopsFragment {
            return WorkshopsFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as? OnFragmentAddedListener ?: throw ClassCastException("$context must implement OnFragmentAddedListener")
        session = SessionManager(context)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_workshops, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val call = getInterfaceService().getWorkshopList(session.token)
        call.enqueue(object : Callback<WorkshopList> {
            override fun onResponse(call: Call<WorkshopList>?, response: Response<WorkshopList>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.workshops?.let {
                        val list = it
                        realm.executeTransaction {
                            it.copyToRealmOrUpdate(list)
                        }
                        showRecycler()
                    }
                } else {
                    Toast.makeText(activity, "Error : $response", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WorkshopList>?, t: Throwable?) {
                Toast.makeText(activity, "Failed to fetch data: ${t?.message}",
                        Toast.LENGTH_SHORT).show()
            }
        })
        mListener.onFragmentAdd(1)
    }

    fun showRecycler() {
        val workshopList = realm.where(WorkshopList::class.java).findFirst()
        workshopList?.workshops?.let {
            workshops_recycler_view.adapter = WorkshopAdapter(it)
            workshops_recycler_view.layoutManager = GridLayoutManager(context, 2)
        }
    }

    class WorkshopAdapter(val list: List<Workshop>) : RecyclerView.Adapter<WorkshopAdapter.WorkshopHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WorkshopHolder {
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_carousels, parent, false)
            return WorkshopHolder(view)
        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: WorkshopHolder, position: Int) {
            holder.title.text = list[position].name
        }

        class WorkshopHolder(val item: View) : RecyclerView.ViewHolder(item) {
            val title = item.event_title_text_view
        }
    }

}
