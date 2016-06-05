package com.profile.javondavis.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO - somewhat uncomfortable with the name of this class
 * @author Javon Davis
 *         Created by Javon Davis on 28/05/16.
 */
public class Skills implements Parcelable, Model {

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

    protected Skills(Parcel in) {
        if (in.readByte() == 0x01) {
            familiar = new ArrayList<>();
            in.readList(familiar, String.class.getClassLoader());
        } else {
            familiar = null;
        }
        if (in.readByte() == 0x01) {
            proficient = new ArrayList<>();
            in.readList(proficient, String.class.getClassLoader());
        } else {
            proficient = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (familiar == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(familiar);
        }
        if (proficient == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(proficient);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Skills> CREATOR = new Parcelable.Creator<Skills>() {
        @Override
        public Skills createFromParcel(Parcel in) {
            return new Skills(in);
        }

        @Override
        public Skills[] newArray(int size) {
            return new Skills[size];
        }
    };
}