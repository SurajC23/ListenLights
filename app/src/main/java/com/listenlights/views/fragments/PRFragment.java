package com.listenlights.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.listenlights.R;
import com.listenlights.adapter.PRMainTabAdapter;

public class PRFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    PRMainTabAdapter mainTabAdapter;

    public PRFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_p_r, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        tabLayout = view.findViewById(R.id.mTabLayout);
        viewPager = view.findViewById(R.id.vpMain);
        setupAdapter(tabLayout,viewPager);
    }

    private void setupAdapter(TabLayout tabLayout, ViewPager2 viewPager) {
        mainTabAdapter = new PRMainTabAdapter(getActivity());
        viewPager.setAdapter(mainTabAdapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) tab.setText("Purchase Request");
                if (position == 1) tab.setText("SO Items");
            }
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(0);
    }
}