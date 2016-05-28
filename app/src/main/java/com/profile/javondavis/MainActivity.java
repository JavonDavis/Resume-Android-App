package com.profile.javondavis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.profile.javondavis.helpers.BaseActivity;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Profile;
import com.profile.javondavis.sixsecond.SixSecondActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    static final String LOG_TAG = "MainActivity";

    @Bind(R.id.locationTextView) TextView locationView;
    @Bind(R.id.picture) ImageView pictureImageView;
    @Bind(R.id.nameTextView) TextView nameView;
    @Bind(R.id.six_second_button) Button sixSecondButton;
    @Bind(R.id.full_portfolio_button) Button fullPortfolioButton;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        DatabaseReference mRef = super.database.getReference("profile");

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                profile = dataSnapshot.getValue(Profile.class);

                Glide
                        .with(MainActivity.this)
                        .load(profile.getImageurl())
                        .into(pictureImageView);

                nameView.setText(profile.getName());
                locationView.setText(profile.getLocation());

                sixSecondButton.setEnabled(true);
                fullPortfolioButton.setEnabled(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onSixSecondButtonClick(View view) {
        Intent intent = new Intent(this, SixSecondActivity.class);
        intent.putExtra(Constants.TAG_PROFILE, profile);
        startActivity(intent);
    }

    public void onFullPortfolioButtonClick(View view) {
        Intent intent = new Intent(this, FullPortfolioActivity.class);
        startActivity(intent);
    }

    public void onMakeYourOwnClick(View view) {
    }

    public void onPictureClick(View view) {
    }
}
