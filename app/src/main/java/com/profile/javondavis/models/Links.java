package com.profile.javondavis.models;

import java.util.ArrayList;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Links {

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
}
