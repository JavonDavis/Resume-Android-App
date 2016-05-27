package com.profile.javondavis.sixsecond;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.profile.javondavis.R;
import com.profile.javondavis.sixsecond.SixSecondPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SixSecondActivity extends AppCompatActivity {

    //pager widget
    @BindView(R.id.pager) private ViewPager mPager;

    //adapter to provide pages to widget
    private SixSecondPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_second);
        ButterKnife.bind(this);

        pagerAdapter = new SixSecondPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }
}

