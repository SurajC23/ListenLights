package com.listenlights.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
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

        mainTabAdapter = new PRMainTabAdapter(getActivity());
        viewPager.setAdapter(mainTabAdapter);


    }
}