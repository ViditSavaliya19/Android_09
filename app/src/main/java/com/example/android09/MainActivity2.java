package com.example.android09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.android09.Adapter.MyAdapter;
import com.example.android09.Adapter.View_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    List images =new ArrayList();
    private ViewPager2 viewPagerImageSlider;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);

        viewPagerImageSlider=findViewById(R.id.viewPagerImageSlider);

        View_Adapter view_adapter=new View_Adapter(MainActivity2.this,images,viewPagerImageSlider);

        viewPagerImageSlider.setAdapter(view_adapter);

        viewPagerImageSlider.setClipToPadding(false);
        viewPagerImageSlider.setClipChildren(false);
        viewPagerImageSlider.setOffscreenPageLimit(4);
        viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPagerImageSlider.setPageTransformer(compositePageTransformer);


        viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });


    }


    Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPagerImageSlider.setCurrentItem(viewPagerImageSlider.getCurrentItem() + 1);
        }
    };
}