package com.ezzy.gadsapp.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ezzy.gadsapp.LearningLeadersFragment;
import com.ezzy.gadsapp.SkillIQLeadersFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    final int tabsNumber = 2;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
//                fragment = new LearningLeadersFragment();
//                break;
                return new LearningLeadersFragment();
            case 1:
                return new SkillIQLeadersFragment();
//                fragment = new SkillIQLeadersFragment();
//                break;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return tabsNumber;
    }

}
