package com.profile.javondavis.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Award implements Parcelable, Model {
    public String date;
    public String issuer;
    public String title;
    public String description;

    public Award()
    {
        // required empty constructor
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Award(Parcel in) {
        date = in.readString();
        issuer = in.readString();
        title = in.readString();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(issuer);
        dest.writeString(title);
        dest.writeString(description);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Award> CREATOR = new Parcelable.Creator<Award>() {
        @Override
        public Award createFromParcel(Parcel in) {
            return new Award(in);
        }

        @Override
        public Award[] newArray(int size) {
            return new Award[size];
        }
    };
}
