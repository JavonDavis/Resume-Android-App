package com.profile.javondavis.sixsecond;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.profile.javondavis.R;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Profile;
import com.profile.javondavis.sixsecond.ui.TopSkillsFragment;
import com.profile.javondavis.sixsecond.ui.education.EducationFragment;
import com.profile.javondavis.sixsecond.ui.organization.OrganizationsFragment;
import com.profile.javondavis.sixsecond.ui.projects.ProjectsFragment;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SixSecondActivity extends AppCompatActivity implements EducationFragment.OnFragmentInteractionListener
        ,OrganizationsFragment.OnFragmentInteractionListener,TopSkillsFragment.OnFragmentInteractionListener
        , ProjectsFragment.OnFragmentInteractionListener {

    private static final String LOG_TAG = "SixSecondActivity";

    //pager widget
    @BindView(R.id.pager) ViewPager mPager;

    //adapter to provide pages to widget
    private SixSecondPagerAdapter pagerAdapter;

    Timer timer;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_second);
        ButterKnife.bind(this);

        Profile profile = getIntent().getParcelableExtra(Constants.TAG_PROFILE);

        pagerAdapter = new SixSecondPagerAdapter(getSupportFragmentManager(), profile);
        mPager.setAdapter(pagerAdapter);
        pageSwitcher();

    }

    private void pageSwitcher() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new SwitchTask(), Constants.NUM_SECONDS, Constants.NUM_SECONDS);
    }

    private class SwitchTask extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > Constants.NUM_PAGES) {
                        timer.cancel();
                        Log.i(LOG_TAG, "Six Seconds finished");
                    } else {
                        mPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

}

