package com.muzi.lasyloadfragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by muzi on 2017/8/29.
 * 727784430@qq.com
 */

public class FragmentFactory {
    private  HashMap<Integer, Fragment> mBaseFragments;

    public FragmentFactory() {
        mBaseFragments = new HashMap<>();
    }

    public  Fragment createFragment(int pos) {
        Fragment baseFragment = mBaseFragments.get(pos);

        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    baseFragment = new ExampleFragment("全部订单");
                    break;
                case 1:
                    baseFragment = new ExampleFragment("待付款");
                    break;
                case 2:
                    baseFragment = new ExampleFragment("待发货");
                    break;
                case 3:
                    baseFragment = new ExampleFragment("待收货");
                    break;
                case 4:
                    baseFragment = new ExampleFragment("待评价");
                    break;
            }
            mBaseFragments.put(pos, baseFragment);
        }
        return baseFragment;
    }
}

