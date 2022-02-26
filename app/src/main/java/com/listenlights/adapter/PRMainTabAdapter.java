package com.listenlights.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.listenlights.views.fragments.subFragments.PurchaseRequestFragment;
import com.listenlights.views.fragments.subFragments.SOItemsFragment;

public class PRMainTabAdapter extends FragmentStateAdapter {

    private String[] titles = new String[] {"Purchase Request", "SO Items"};

    public PRMainTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new PurchaseRequestFragment();

            case 1:
                return new SOItemsFragment();
        }
        return new PurchaseRequestFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
