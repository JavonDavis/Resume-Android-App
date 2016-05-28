package com.profile.javondavis.models;

import java.util.List;

/**
 * TODO - somewhat uncomfortable with the name of this class
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Skills {

    public List<String> familiar;
    public List<String> proficient;

    public Skills()
    {
        //required empty constructor
    }

    public List<String> getFamiliar() {
        return familiar;
    }

    public void setFamiliar(List<String> familiar) {
        this.familiar = familiar;
    }

    public List<String> getProficient() {
        return proficient;
    }

    public void setProficient(List<String> proficient) {
        this.proficient = proficient;
    }
}
