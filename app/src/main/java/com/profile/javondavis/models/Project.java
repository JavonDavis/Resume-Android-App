package com.profile.javondavis.models;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Project {

    public String date;
    public String description;
    public String source;
    public String title;
    public String url;

    public Project()
    {
        // required empty constructor
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
