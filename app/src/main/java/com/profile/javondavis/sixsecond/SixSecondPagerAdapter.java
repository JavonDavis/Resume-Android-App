package com.profile.javondavis.sixsecond;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Profile;
import com.profile.javondavis.sixsecond.ui.EducationFragment;
import com.profile.javondavis.sixsecond.ui.OrganizationsFragment;
import com.profile.javondavis.sixsecond.ui.ProjectsFragment;
import com.profile.javondavis.sixsecond.ui.TopSkillsFragment;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 26/05/16.
 */
public class SixSecondPagerAdapter extends FragmentStatePagerAdapter {

    private Profile profile;
    public SixSecondPagerAdapter(FragmentManager fm, Profile profile) {
        super(fm);
        this.profile = profile;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case Constants.PAGE_EDUCATION:
                return EducationFragment.newInstance(profile.getFirstname(),profile.getEducations().get(0));
            case Constants.PAGE_SKILLS:
                return TopSkillsFragment.newInstance(profile.getFirstname(),profile.getSkills());
            case Constants.PAGE_ORGANIZATIONS:
                return OrganizationsFragment.newInstance(profile.getFirstname(),profile.getWorkexperiences());
            case Constants.PAGE_PROJECTS:
                return ProjectsFragment.newInstance(profile.getFirstname(),profile.getProjects());
        }
        return EducationFragment.newInstance(profile.getFirstname(), profile.getEducations().get(0));
    }

    @Override
    public int getCount() {
        return Constants.NUM_PAGES;
    }
}
