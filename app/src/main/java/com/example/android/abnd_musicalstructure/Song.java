package com.example.android.abnd_musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Corentin on 12/03/2018.
 * Implements Parcelable to send an arrayList of songs in another activity
 */

public class Song implements Parcelable{
    private String artist;
    private String name;

    public Song(String artist, String name) {
        this.artist = artist;
        this.name = name;
    }

    public String getArtist() {return artist;}

    public String getName() {
        return name;
    }

    protected Song(Parcel in) {
        artist = in.readString();
        name = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(artist);
        dest.writeString(name);
    }
}
