package com.cognizance.cognizance18.Addmembers;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cognizance.cognizance18.R;

import java.sql.BatchUpdateException;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberIdFragment extends Fragment {


    public MemberIdFragment() {
        // Required empty public constructor
    }

    private EditText member1, member2, member3, member4, member5, member6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_id,container, false);

        //savebtn and cancel button
        Button savebtn = getActivity().findViewById(R.id.save_button);
        savebtn.setVisibility(View.VISIBLE);
        Button cancelbtn = getActivity().findViewById(R.id.add_members_cancel);

        //View intialization
        initViews(view);
        //change of color on text change
        member1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String s1 = s.toString();
                if (s1!=null){
                    savebtn.setBackground(ResourcesCompat.getDrawable( getResources(),R.drawable.button_background,null));
                    member2.setVisibility(View.VISIBLE);
                }
            }
        });
        member2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString()!=null){
                    member3.setVisibility(View.VISIBLE);
                }
            }
        });
        member3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                member4.setVisibility(View.VISIBLE);
            }
        });
        member4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                member5.setVisibility(View.VISIBLE);
            }
        });
        member5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                member6.setVisibility(View.VISIBLE);
            }
        });

//        SharedPreferences preferences = getActivity().getSharedPreferences("MyPref",0);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("member1",member1.getText().toString().trim());
//        if (!member2.getText().toString().isEmpty()){
//            editor.putString("member2",member2.getText().toString().trim());
//        }
//        if (!member3.getText().toString().isEmpty()){
//            editor.putString("member3",member3.getText().toString().trim());
//        }
//        if (!member4.getText().toString().isEmpty()){
//            editor.putString("member4",member4.getText().toString().trim());
//        }
//        if (!member5.getText().toString().isEmpty()){
//            editor.putString("member5",member5.getText().toString().trim());
//        }
//        if (!member6.getText().toString().isEmpty()){
//            editor.putString("member6",member6.getText().toString().trim());
//        }
//        editor.apply();

        return view;
    }

    private void initViews(View view){
        member1 = view.findViewById(R.id.member1);
        member2 = view.findViewById(R.id.member2);
        member2.setVisibility(View.GONE);
        member3 = view.findViewById(R.id.member3);
        member3.setVisibility(View.GONE);
        member4 = view.findViewById(R.id.member4);
        member4.setVisibility(View.GONE);
        member5 = view.findViewById(R.id.member5);
        member5.setVisibility(View.GONE);
        member6 = view.findViewById(R.id.member6);
        member6.setVisibility(View.GONE);
    }
}
