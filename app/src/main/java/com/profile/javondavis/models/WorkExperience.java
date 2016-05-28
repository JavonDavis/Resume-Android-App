package com.profile.javondavis.models;

import java.util.List;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class WorkExperience {

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
}
