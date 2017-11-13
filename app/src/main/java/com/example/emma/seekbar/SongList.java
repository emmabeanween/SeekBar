package com.example.emma.seekbar;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Emma on 10/16/17.
 */

public class SongList {


private List<Song> mSongList;







    public SongList(Context context){

         mSongList = new ArrayList<>();
        createList();


    }




public void createList(){


    mSongList.add(new Song(UUID.randomUUID(), "Clocks", "Coldplay",R.raw.clocks ));
    mSongList.add(new Song(UUID.randomUUID(), "Fix You", "Coldplay", R.raw.fixyou ));
    mSongList.add(new Song(UUID.randomUUID(), "Hymn for the Weekend", "Coldplay", R.raw.hymn ));
    mSongList.add(new Song(UUID.randomUUID(), "Paradise", "Coldplay", R.raw.paradise));
    mSongList.add(new Song(UUID.randomUUID(), "Sky Full of Stars", "Coldplay", R.raw.skyfullofstars));
    mSongList.add(new Song(UUID.randomUUID(), "The Scientist", "Coldplay", R.raw.thescientist));
    mSongList.add(new Song(UUID.randomUUID(), "Yellow", "Coldplay", R.raw.yellow));

    Log.i("TAG", "list created");
}


public List<Song>  getmSongList() {

    return mSongList;
}





}
