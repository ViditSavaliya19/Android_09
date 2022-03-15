package com.example.android09.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.android09.MainActivity2;
import com.example.android09.R;

import java.util.Objects;

public class MyAdapter extends PagerAdapter {
    Activity activity;
    int[] images;

    public MyAdapter(MainActivity2 mainActivity2, int[] images) {
        activity = mainActivity2;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item, container, false);
        ImageView img = view.findViewById(R.id.img);
        img.setImageResource(images[position]);

        Objects.requireNonNull(container).addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);

    }
}
