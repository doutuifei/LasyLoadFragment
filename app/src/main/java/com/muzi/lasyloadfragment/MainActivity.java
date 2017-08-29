package com.muzi.lasyloadfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewpager;
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        String[] title = new String[]{"全部订单", "待付款", "待发货", "待收货", "待评价"};

        fragmentAdapter = new FragmentAdapter(title, getSupportFragmentManager());
        viewpager.setAdapter(fragmentAdapter);
        viewpager.setOffscreenPageLimit(title.length - 1);
        tabLayout.setupWithViewPager(viewpager);
    }
}
