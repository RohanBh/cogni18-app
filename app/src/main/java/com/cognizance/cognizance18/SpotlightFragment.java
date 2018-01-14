package com.cognizance.cognizance18;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;

public class SpotlightFragment extends Fragment {

    private OnFragmentAddedListener mListener;

    public static SpotlightFragment newInstance() {
        SpotlightFragment fragment = new SpotlightFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentAddedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnFragmentAddedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mListener.onFragmentAdd(3);
        return inflater.inflate(R.layout.fragment_spotlight, container, false);
    }
}
