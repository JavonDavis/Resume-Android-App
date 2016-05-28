package com.profile.javondavis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.profile.javondavis.sixsecond.SixSecondActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.locationTextView) TextView locationView;
    @Bind(R.id.picture) ImageView pictureImageView;
    @Bind(R.id.nameTextView) TextView nameView;

    static boolean calledAlready = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (!calledAlready)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            calledAlready = true;
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference mRef = database.getReference("profile");

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = (String) dataSnapshot.child("name").getValue();
                String imageUrl = (String) dataSnapshot.child("imageurl").getValue();
                String location = (String) dataSnapshot.child("location").getValue();

                Glide
                        .with(MainActivity.this)
                        .load(imageUrl.trim())
                        .into(pictureImageView);

                nameView.setText(name.trim());
                locationView.setText(location.trim());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
