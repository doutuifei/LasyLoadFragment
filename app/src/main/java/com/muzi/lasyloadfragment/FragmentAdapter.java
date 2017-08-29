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

    public FragmentAdapter(String[] title, FragmentManager fm) {
        super(fm);
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = FragmentFactory.createFragment(position);
        return fragment;
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