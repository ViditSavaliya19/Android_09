package com.example.android09.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android09.R;

public class Details_Fragment extends Fragment {


    public static TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_details_, container, false);
        // Inflate the layout for this fragment
        txt=view.findViewById(R.id.txt);


        return view;
    }
}