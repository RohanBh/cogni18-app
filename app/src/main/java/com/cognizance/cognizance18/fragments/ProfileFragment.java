package com.cognizance.cognizance18.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;

public class ProfileFragment extends Fragment {

    private OnFragmentAddedListener mListener;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentAddedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnFragmentAddedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mListener.onFragmentAdd(4);
        return inflater.inflate(R.layout.your_profile_layout, container, false);
    }
}
