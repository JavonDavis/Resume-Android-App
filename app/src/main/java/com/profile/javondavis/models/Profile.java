package com.profile.javondavis.models;

import java.util.List;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Profile {

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
}
