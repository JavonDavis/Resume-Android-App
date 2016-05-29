package com.profile.javondavis.helpers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class BaseActivity extends AppCompatActivity {

    static boolean calledAlready = false;
    protected FirebaseDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (!calledAlready)
//        {
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//            calledAlready = true;
//        }

        database = FirebaseDatabase.getInstance();

    }
}
