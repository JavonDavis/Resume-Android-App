package com.profile.javondavis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.profile.javondavis.sixsecond.SixSecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onSixSecondClick(View view) {
        Intent intent = new Intent(this, SixSecondActivity.class);
        startActivity(intent);
    }

    public void onFullPortfolioClick(View view) {
        Intent intent = new Intent(this, FullPortfolioActivity.class);
        startActivity(intent);
    }

    public void onMakeYourOwnClick(View view) {
    }

    public void onPictureClick(View view) {
    }
}
