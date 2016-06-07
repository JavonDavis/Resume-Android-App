package com.profile.javondavis.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Education implements Parcelable, Model {

    public ArrayList<String> courses;

    public String degree;
    public String minor;
    public String major;
    public String end;
    public String name;
    public String start;
    public String study;

    public Education()
    {
        // required empty constructor
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    protected Education(Parcel in) {
        if (in.readByte() == 0x01) {
            courses = new ArrayList<String>();
            in.readList(courses, String.class.getClassLoader());
        } else {
            courses = null;
        }
        degree = in.readString();
        minor = in.readString();
        major = in.readString();
        end = in.readString();
        name = in.readString();
        start = in.readString();
        study = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (courses == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(courses);
        }
        dest.writeString(degree);
        dest.writeString(minor);
        dest.writeString(major);
        dest.writeString(end);
        dest.writeString(name);
        dest.writeString(start);
        dest.writeString(study);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Education> CREATOR = new Parcelable.Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };
}
