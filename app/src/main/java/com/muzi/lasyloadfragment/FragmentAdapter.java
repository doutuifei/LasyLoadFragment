package com.muzi.lasyloadfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by muzi on 2017/8/29.
 * 727784430@qq.com
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    String[] title = null;
    FragmentFactory fragmentFactory;

    public FragmentAdapter(String[] title, FragmentManager fm) {
        super(fm);
        this.title = title;
        fragmentFactory = new FragmentFactory();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentFactory.createFragment(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return title.length;
    }
}