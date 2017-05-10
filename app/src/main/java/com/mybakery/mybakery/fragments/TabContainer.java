package com.mybakery.mybakery.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mybakery.mybakery.R;
import com.mybakery.mybakery.adapters.ViewPagerAdapter;


public class TabContainer extends Fragment
{
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public TabContainer()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_container, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return  view;
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentOne(), "ONE");
        adapter.addFragment(new FragmentTwo(), "TWO");
        adapter.addFragment(new FragmentOne(), "THREE");
        adapter.addFragment(new FragmentTwo(), "FOUR");
        adapter.addFragment(new FragmentOne(), "FIVE");
        adapter.addFragment(new FragmentTwo(), "SIX");
        adapter.addFragment(new FragmentOne(), "SEVEN");
        adapter.addFragment(new FragmentTwo(), "EIGHT");
        viewPager.setAdapter(adapter);
    }

}
