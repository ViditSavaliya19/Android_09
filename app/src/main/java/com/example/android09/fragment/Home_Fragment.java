package com.example.android09.fragment;

import static com.example.android09.fragment.Details_Fragment.txt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android09.R;

public class Home_Fragment extends Fragment {

    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        btn=view.findViewById(R.id.btn);


        return view;
    }
}