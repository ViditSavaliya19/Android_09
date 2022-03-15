package com.example.android09.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android09.MainActivity2;
import com.example.android09.R;


import java.util.List;
public class View_Adapter extends RecyclerView.Adapter<View_Adapter.SliderData> {

    Activity activity;
    List images;
    ViewPager2 viewPager2;

    public View_Adapter(MainActivity2 mainActivity2, List images, ViewPager2 viewPagerImageSlider) {
        activity = mainActivity2;
        this.images = images;
        viewPager2 = viewPagerImageSlider;
    }

    @NonNull
    @Override
    public SliderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item, parent, false);
        return new SliderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderData holder, int position) {
        holder.img.setImageResource((Integer) images.get(position));

        viewPager2.post(runnable);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class SliderData extends RecyclerView.ViewHolder {
        private final ImageView img;

        public SliderData(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            images.addAll(images);
        }
    };
}
