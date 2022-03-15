package com.example.android09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android09.Adapter.Tab_Adapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity3 extends AppCompatActivity {

    private TabLayout tab_bar;
    private ViewPager view_pager;
    private DrawerLayout drawer ;
    private NavigationView navgation;
    private ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tab_bar=findViewById(R.id.tab_bar);

        menu=findViewById(R.id.menu);
        drawer=findViewById(R.id.drawer);
        navgation=findViewById(R.id.navgation);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });



        view_pager=findViewById(R.id.view_pager);

        tab_bar.addTab(tab_bar.newTab().setText("Chat"));
        tab_bar.addTab(tab_bar.newTab().setText("Status"));
        tab_bar.addTab(tab_bar.newTab().setText("Call"));


        Tab_Adapter tab_adapter=new Tab_Adapter(MainActivity3.this,getSupportFragmentManager());
        view_pager.setAdapter(tab_adapter);

        //tab-viewpageer
        tab_bar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //viewpager - tab
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_bar));
    }
}