package com.android.kusitms.kbscilpoon.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.kusitms.kbscilpoon.Fragment.FirstFragment;
import com.android.kusitms.kbscilpoon.Fragment.SecondFragment;
import com.android.kusitms.kbscilpoon.Fragment.ThirdFragment;

public class CustomAdapter extends FragmentStatePagerAdapter{

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 1:
                return  new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return new FirstFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
