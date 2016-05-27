package com.profile.javondavis.sixsecond;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.profile.javondavis.Constants;
import com.profile.javondavis.sixsecond.ui.EducationFragment;
import com.profile.javondavis.sixsecond.ui.OrganizationsFragment;
import com.profile.javondavis.sixsecond.ui.ProjectsFragment;
import com.profile.javondavis.sixsecond.ui.TopSkillsFragment;

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
                return EducationFragment.newInstance();
            case Constants.PAGE_SKILLS:
                return TopSkillsFragment.newInstance();
            case Constants.PAGE_ORGANIZATIONS:
                return OrganizationsFragment.newInstance();
            case Constants.PAGE_PROJECTS:
                return ProjectsFragment.newInstance();
        }
        return EducationFragment.newInstance();
    }

    @Override
    public int getCount() {
        return Constants.NUM_PAGES;
    }
}
