package com.cognizance.cognizance18.Addmembers;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.R;

/**
 * Created by shashank on 10/2/18.
 */

public class MembersFragment extends android.support.v4.app.Fragment {


    public static MembersFragment newInstance() {
        MembersFragment fragment = new MembersFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.add_members1, container, false);


        return v1;
    }


}
