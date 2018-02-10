package com.cognizance.cognizance18.Addmembers;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.adapters.AddMembersAdapter;

/**
 * Created by Narendra on 10/2/18.
 */

public class AddMembersPage extends AppCompatActivity implements View.OnClickListener {

    private android.support.v4.app.FragmentTransaction fragmentTransaction;
    private ImageView crossImg;
    private Button cancelbtn, addMembersbtn, savebtn, undobtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_members_page);

        //cross button
        crossImg = findViewById(R.id.cross);

        //assigning initial fragment
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.add_members_container,new MembersFragment());
        fragmentTransaction.commit();

        //cancel button
        cancelbtn = findViewById(R.id.add_members_cancel);

        //add members button
        addMembersbtn = findViewById(R.id.add_member_button);
        addMembersbtn.setOnClickListener(this);

        //save button
        savebtn = findViewById(R.id.save_button);
        savebtn.setOnClickListener(this);

        //undo button
        undobtn = findViewById(R.id.add_members_delete);
        undobtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.add_member_button :
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.add_members_container,new MemberIdFragment());
                fragmentTransaction.commit();
                break;

            case R.id.save_button :
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.add_members_container, new TeamDisplayFragment());
                fragmentTransaction.commit();
                break;

        }
    }
}
