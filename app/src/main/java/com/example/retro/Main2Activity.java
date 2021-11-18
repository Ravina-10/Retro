
package com.example.retro;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView home, about, events, sponsors;
    Viewpageradapter viewpageradapter;

    ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        home=(TextView)findViewById((R.id.home));
//
//        about=(TextView)findViewById((R.id.about));
//
//        events=(TextView)findViewById((R.id.events));
//
//        sponsors=(TextView)findViewById((R.id.sponsors));

        viewPager = (ViewPager)findViewById(R.id.fragment_container);
        TabLayout tabLayout=findViewById(R.id.tabs);
        viewpageradapter = new Viewpageradapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewpageradapter.addFragment(new Fragment_Home(),"Home");

        viewpageradapter.addFragment(new Fragment_Events(),"Events");
        viewpageradapter.addFragment(new Fragment_Sponsors(),"Sponsors");
        viewpageradapter.addFragment(new Fragment_About(),"About");
        viewPager.setAdapter(viewpageradapter);
        tabLayout.setupWithViewPager(viewPager);

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(0);
//            }
//        });
//
//
//        about.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(1);
//            }
//        });
//
//
//        events.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(2);
//            }
//        });
//
//
//        sponsors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(3);
//            }
//        });

//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onPageSelected(int position) {
//                onChangeTab(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }


//    @RequiresApi(api = Build.VERSION_CODES.M)
//    private void onChangeTab(int position) {
//        if (position == 0) {
//            home.setTextSize(20);
//
//            //home.setTextColor(getColor(R.color.bright_color));
//
//            about.setTextSize(15);
//            //about.setTextColor(getColor(R.color.light_color));
//
//            sponsors.setTextSize(15);
//            // sponsors.setTextColor(getColor(R.color.light_color));
//
//            events.setTextSize(15);
//            // events.setTextColor(getColor(R.color.light_color));
//
//        }
//
//
//        if (position == 1) {
//            home.setTextSize(15);
//            //   home.setTextColor(getColor(R.color.light_color));
//
//            about.setTextSize(20);
//            //   about.setTextColor(getColor(R.color.bright_color));
//
//            sponsors.setTextSize(15);
//            //  sponsors.setTextColor(getColor(R.color.light_color));
//
//            events.setTextSize(15);
//            //events.setTextColor(getColor(R.color.light_color));
//
//        }
//
//
//        if (position == 3) {
//            home.setTextSize(15);
//            //home.setTextColor(getColor(R.color.light_color));
//
//            about.setTextSize(15);
//            // about.setTextColor(getColor(R.color.light_color));
//
//            sponsors.setTextSize(20);
//            //  sponsors.setTextColor(getColor(R.color.bright_color));
//
//            events.setTextSize(15);
//            //  events.setTextColor(getColor(R.color.light_color));
//
//        }
//
//
//        if (position == 2) {
//            home.setTextSize(15);
//            //home.
//            // home.setTextColor(getColor(R.color.light_color));
//
//            about.setTextSize(15);
//            //  about.setTextColor(getColor(R.color.light_color));
//
//            sponsors.setTextSize(15);
//            //   sponsors.setTextColor(getColor(R.color.light_color));
//
//            events.setTextSize(20);
//            // events.setPaintFlags(events.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
//            // events.setTextColor(getColor(R.color.bright_color));
//
//        }
//
//
//    }
class Viewpageradapter extends FragmentPagerAdapter{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public Viewpageradapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}

}

