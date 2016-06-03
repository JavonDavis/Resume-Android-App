package com.profile.javondavis.helpers;

import com.profile.javondavis.models.Model;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 03/06/2016.
 */

public class HeaderListItem extends ListItem {

    private String pictureUrl;
    private String name;

    public HeaderListItem(String pictureUrl, String name) {
        this.pictureUrl = pictureUrl;
        this.name = name;
    }

    @Override
    public int getViewType() {
        return ListItem.VIEW_TYPE_HEADER;
    }

    @Override
    public Model getModel() {
        return null;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
