package com.example.android09.Adapter;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android09.MainActivity3;
import com.example.android09.fragment.Details_Fragment;
import com.example.android09.fragment.Home_Fragment;

public class Tab_Adapter extends FragmentPagerAdapter {
    Activity activity;
    public Tab_Adapter(MainActivity3 mainActivity3, @NonNull FragmentManager fm) {
        super(fm);
        this.activity=mainActivity3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Home_Fragment();
            case 1:
                return new Details_Fragment();
            case 2:
                return new Home_Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
