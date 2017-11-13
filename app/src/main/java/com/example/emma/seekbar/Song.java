package com.example.emma.seekbar;

import android.graphics.Bitmap;

import java.util.UUID;

/**
 * Created by Emma on 10/16/17.
 */

public class Song {

    private UUID mSongId;
    private String mSongTitle;
    private String mSongAuthor;

    private int mSongContent;


    public Song(UUID id, String title, String author, int content){

        mSongId = id;
        mSongTitle = title;
        mSongAuthor = author;
        mSongContent = content;


    }


    public UUID getmSongId() {
        return mSongId;
    }

    public String getmSongTitle() {
        return mSongTitle;
    }

    public String getmSongAuthor() {
        return mSongAuthor;
    }



    public int getmSongContent() {
        return mSongContent;
    }
}
