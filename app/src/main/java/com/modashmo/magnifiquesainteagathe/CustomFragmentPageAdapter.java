package com.modashmo.magnifiquesainteagathe;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Magnifique Sainte-Agathe
 * Created by Mauricio recyclerViewClickListener May 14, 2017
 * <p>
 * Udacity Android Basics Nanodegree
 * Project 6: Tour App
 */
class CustomFragmentPageAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "FOOD & FUN", "HISTORIC PLACES", "SHOPPING", "EVENTS" };
    private static final int PAGE_COUNT = 4;
    private Context context;

    CustomFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FoodFunFragment();
        } else if (position == 1){
            return new HistoricPlacesFragment();
        } else if (position == 2) {
            return new ShoppingFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based recyclerViewClickListener item position
        return tabTitles[position];
    }
}
