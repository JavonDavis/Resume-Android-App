package com.profile.javondavis.helpers;

import com.profile.javondavis.models.Model;

/**
 * Used to represent a List item on the FullPortfolio page
 *
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */
public abstract class ListItem {

    public static final int VIEW_TYPE_SKILLS = 0;
    public static final int VIEW_TYPE_EDUCATION = 1;
    public static final int VIEW_TYPE_PROJECT = 2;
    public static final int VIEW_TYPE_EXPERIENCE = 3;
    public static final int VIEW_TYPE_AWARD = 4;
    public static final int VIEW_TYPE_CERTIFICATION = 5;

    public static final int VIEW_TYPE_HEADER = 6;
    public static final int VIEW_TYPE_SECTION_HEADER = 7;

    public static final int ITEM_COUNT = 6;

    public abstract int getViewType();
    public abstract Model getModel();
}
