package com.profile.javondavis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.profile.javondavis.fullportfolio.FullPortfolioActivity;
import com.profile.javondavis.helpers.BaseActivity;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Profile;
import com.profile.javondavis.sixsecond.SixSecondActivity;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    static final String LOG_TAG = "MainActivity";

    @BindView(R.id.locationTextView) TextView locationView;
    @BindView(R.id.picture) ImageView pictureImageView;
    @BindView(R.id.nameTextView) TextView nameView;
    @BindView(R.id.six_second_button) Button sixSecondButton;
    @BindView(R.id.full_portfolio_button) Button fullPortfolioButton;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String jsonProfile = loadProfile();

        if(jsonProfile != null) {
            profile = new Gson().fromJson(jsonProfile, Profile.class);

            Glide
                    .with(MainActivity.this)
                    .load(profile.getImageurl())
                    .into(pictureImageView);

            nameView.setText(profile.getName());
            locationView.setText(profile.getLocation());

            sixSecondButton.setEnabled(true);
            fullPortfolioButton.setEnabled(true);
        }
    }

    private String loadProfile() {
        String json;
        try {
            InputStream is = getAssets().open("profile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void onSixSecondButtonClick(View view) {
        Intent intent = new Intent(this, SixSecondActivity.class);
        intent.putExtra(Constants.TAG_PROFILE, profile);
        startActivity(intent);
    }

    public void onFullPortfolioButtonClick(View view) {
        Intent intent = new Intent(this, FullPortfolioActivity.class);
        intent.putExtra(Constants.TAG_PROFILE, profile);
        startActivity(intent);
    }

    public void onMakeYourOwnClick(View view) {
        String url = "https://github.com/JA-VON/Resume-Android-App";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void onPictureClick(View view) {
    }
}
