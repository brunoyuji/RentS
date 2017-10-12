package com.example.wesleysantos.aluguel.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.wesleysantos.aluguel.view.fragments.FragmentA;
import com.example.wesleysantos.aluguel.view.fragments.FragmentB;
import com.example.wesleysantos.aluguel.view.fragments.FragmentC;


public class FragmentAdapter extends FragmentStatePagerAdapter {
    private String[] tabsTitles;

    public FragmentAdapter(FragmentManager fm, String[] tabsTitles) {
        super(fm);
        this.tabsTitles = tabsTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            case 2:
                return new FragmentC();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabsTitles[position];
    }

    @Override
    public int getCount() {
        return this.tabsTitles.length;
    }
}
