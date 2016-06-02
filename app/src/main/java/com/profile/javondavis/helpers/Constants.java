package com.profile.javondavis.helpers;

import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 26/05/16.
 */
public final class Constants {

    public static final int NUM_PAGES = 4;

    public static final int PAGE_EDUCATION = 0;
    public static final int PAGE_SKILLS = 1;
    public static final int PAGE_ORGANIZATIONS = 2;
    public static final int PAGE_PROJECTS = 3;

    public static final String TAG_PROFILE = "Profile";
    public static final String TAG_EDUCATION = "Education";
    public static final String TAG_SKILLS = "Skills";
    public static final String TAG_PROJECTS = "Projects";
    public static final String TAG_ORGANIZATIONS = "Organizations";

    public static final String TAG_NAME = "name";

    public static final String DATE_FORMAT = "MMMM yyyy";

    public static final Locale LOCALE = Locale.ENGLISH;

    public static boolean isDateAfterToday(Date date)
    {
        Calendar c = Calendar.getInstance();

        // set the calendar to start of today
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        // and get that as a Date
        Date today = c.getTime();

        return date.after(today);
    }


    public static Date getDateFromString(String tag, String dateString)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Constants.LOCALE);

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            Log.e(tag, "Could not parse "+dateString+". Current format is:"+Constants.DATE_FORMAT);
        }
        return null;
    }

    public static final ButterKnife.Action<View> VISIBILITY_GONE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setVisibility(View.GONE);
        }
    };

}
