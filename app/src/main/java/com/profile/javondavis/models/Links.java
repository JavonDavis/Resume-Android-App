package com.profile.javondavis.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Links implements Parcelable, Model {

    public ArrayList<String> emails;
    public String github;
    public String linkedin;

    public Links()
    {
        // required empty constructor
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    protected Links(Parcel in) {
        if (in.readByte() == 0x01) {
            emails = new ArrayList<String>();
            in.readList(emails, String.class.getClassLoader());
        } else {
            emails = null;
        }
        github = in.readString();
        linkedin = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (emails == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(emails);
        }
        dest.writeString(github);
        dest.writeString(linkedin);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Links> CREATOR = new Parcelable.Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
}