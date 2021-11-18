package com.example.retro;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position)
    {
        Fragment fragment = null;

        switch(position){

            case 0:
                fragment = new Fragment_Home();
                break;
            case 1:
                fragment = new Fragment_About();
                break;
            case 2:
                fragment = new Fragment_Events();
                break;
            case 3:
                fragment = new Fragment_Sponsors();
                break;


        }
        return fragment;

    }

    public int getCount(){
        return 4;
    }
}
