package com.profile.javondavis.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class WorkExperience implements Parcelable, Model {

    public String employer;
    public String start;
    public String end;
    public String location;
    public String position;

    public List<Link> links;
    public List<String> responsibilities;

    public WorkExperience()
    {
        // required empty constructor
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    protected WorkExperience(Parcel in) {
        employer = in.readString();
        start = in.readString();
        end = in.readString();
        location = in.readString();
        position = in.readString();
        if (in.readByte() == 0x01) {
            links = new ArrayList<Link>();
            in.readList(links, Link.class.getClassLoader());
        } else {
            links = null;
        }
        if (in.readByte() == 0x01) {
            responsibilities = new ArrayList<String>();
            in.readList(responsibilities, String.class.getClassLoader());
        } else {
            responsibilities = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(employer);
        dest.writeString(start);
        dest.writeString(end);
        dest.writeString(location);
        dest.writeString(position);
        if (links == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(links);
        }
        if (responsibilities == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(responsibilities);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WorkExperience> CREATOR = new Parcelable.Creator<WorkExperience>() {
        @Override
        public WorkExperience createFromParcel(Parcel in) {
            return new WorkExperience(in);
        }

        @Override
        public WorkExperience[] newArray(int size) {
            return new WorkExperience[size];
        }
    };
}