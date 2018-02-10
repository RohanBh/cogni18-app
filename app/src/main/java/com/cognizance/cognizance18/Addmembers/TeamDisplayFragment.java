package com.cognizance.cognizance18.Addmembers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.adapters.AddMembersAdapter;
import com.cognizance.cognizance18.models.UserDetails;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamDisplayFragment extends Fragment {


    public TeamDisplayFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private List<UserDetails> userDetailsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_display, container, false);

        //recycler View
        recyclerView = view.findViewById(R.id.display_members);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AddMembersAdapter(getActivity(), userDetailsList));

        //Delete Button
        Button deletebtn = getActivity().findViewById(R.id.add_members_delete);
        deletebtn.setVisibility(View.VISIBLE);

        return view;
    }

}
