package com.uygulamalarim.istanbul_times_news_app_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.uygulamalarim.istanbul_times_news_app_retrofit.Adapters.PagerAdapter;

import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    TabLayout tablayout;
    TabItem home,economy,sports,entertainment,science,health;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    String api="a7bc57a275cc4f8780a86964a219af0e";



    // url: https://newsapi.org/v2/everything?q=gaming&from=2022-07-19&sortBy=publishedAt&apiKey=a7bc57a275cc4f8780a86964a219af0e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    public void initView(){
        home=findViewById(R.id.homeitem);
        economy=findViewById(R.id.economyitem);
        sports=findViewById(R.id.sportsitem);
        entertainment=findViewById(R.id.entertainmentitem);
        science=findViewById(R.id.scienceitem);
        health=findViewById(R.id.healthitem);
        ViewPager viewPager=findViewById(R.id.fragmentContainer);
        TabLayout tabLayout=findViewById(R.id.tablayout);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}