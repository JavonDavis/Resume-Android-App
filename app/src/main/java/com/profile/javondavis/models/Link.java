package com.profile.javondavis.models;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Link {

    public String description;
    public String link;

    public Link()
    {
        //required empty constructor
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
