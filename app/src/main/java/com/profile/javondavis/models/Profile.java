package com.profile.javondavis.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Profile implements Parcelable {

    public String name;
    public String firstname;
    public String surname;

    public String title;
    public String summary;
    public String imageurl;
    public String location;

    public List<Award> awards;
    public List<Education> educations;
    public List<WorkExperience> workexperiences;
    public List<Project> projects;

    public Skills skills;
    public Links links;

    public Profile()
    {
        // Default constructor required for calls to DataSnapshot.getValue(Profile.class)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<WorkExperience> getWorkexperiences() {
        return workexperiences;
    }

    public void setWorkexperiences(List<WorkExperience> workexperiences) {
        this.workexperiences = workexperiences;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    protected Profile(Parcel in) {
        name = in.readString();
        firstname = in.readString();
        surname = in.readString();
        title = in.readString();
        summary = in.readString();
        imageurl = in.readString();
        location = in.readString();
        if (in.readByte() == 0x01) {
            awards = new ArrayList<Award>();
            in.readList(awards, Award.class.getClassLoader());
        } else {
            awards = null;
        }
        if (in.readByte() == 0x01) {
            educations = new ArrayList<Education>();
            in.readList(educations, Education.class.getClassLoader());
        } else {
            educations = null;
        }
        if (in.readByte() == 0x01) {
            workexperiences = new ArrayList<WorkExperience>();
            in.readList(workexperiences, WorkExperience.class.getClassLoader());
        } else {
            workexperiences = null;
        }
        if (in.readByte() == 0x01) {
            projects = new ArrayList<Project>();
            in.readList(projects, Project.class.getClassLoader());
        } else {
            projects = null;
        }
        skills = (Skills) in.readValue(Skills.class.getClassLoader());
        links = (Links) in.readValue(Links.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(firstname);
        dest.writeString(surname);
        dest.writeString(title);
        dest.writeString(summary);
        dest.writeString(imageurl);
        dest.writeString(location);
        if (awards == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(awards);
        }
        if (educations == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(educations);
        }
        if (workexperiences == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(workexperiences);
        }
        if (projects == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(projects);
        }
        dest.writeValue(skills);
        dest.writeValue(links);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
