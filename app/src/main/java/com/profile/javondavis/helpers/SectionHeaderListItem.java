package com.profile.javondavis.helpers;

import com.profile.javondavis.models.Model;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 03/06/2016.
 */
public class SectionHeaderListItem extends ListItem {

    private String mTitle;

    public SectionHeaderListItem(String title)
    {
        this.mTitle = title;
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_SECTION_HEADER;
    }

    @Override
    public Model getModel() {
        return null;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
