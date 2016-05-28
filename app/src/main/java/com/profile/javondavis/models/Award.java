package com.profile.javondavis.models;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Award {
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
}
