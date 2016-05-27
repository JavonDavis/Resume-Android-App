package com.profile.javondavis.sixsecond;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.profile.javondavis.Constants;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 26/05/16.
 */
public class SixSecondPagerAdapter extends FragmentStatePagerAdapter {

    public SixSecondPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case Constants.PAGE_EDUCATION:
                break;
            case Constants.PAGE_SKILLS:
                break;
            case Constants.PAGE_ORGANIZATIONS:
                break;
            case Constants.PAGE_PROJECTS:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return Constants.NUM_PAGES;
    }
}
