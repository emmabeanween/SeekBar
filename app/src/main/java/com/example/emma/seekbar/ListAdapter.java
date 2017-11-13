package com.example.emma.seekbar;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emma on 10/22/17.
 */

public class ListAdapter extends ArrayAdapter<Song> {


    private MediaPlayer mPlayer;
    private TextView mSongTextView;
    private TextView mAuthorTextView;
    private TextView mTimeTextView;
    private SeekBar mSeekBar;
    private int length = 0;
    private ImageButton mSongButton;
    private SeekBar mBar;
    private TextView mTimeView;
    String status = "play";
    private List<Song> mItems = new ArrayList<>();

    public ListAdapter(Context context, int resource, List<Song> items, SeekBar Bar, TextView mTextView) {
        super(context, resource, items);
        mItems = items;
        mBar = Bar;
        mTimeView  = mTextView;


    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LayoutInflater inflater=  (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.custom_layout, null);
        View otherView = inflater.inflate(R.layout.activity_main, null);
        final Song eachSong = mItems.get(position);


        mSongTextView = (TextView)v.findViewById(R.id.song_title_view);
        mAuthorTextView = (TextView)v.findViewById(R.id.song_author_view);






        mSongTextView.setText(eachSong.getmSongTitle());
        mAuthorTextView.setText(eachSong.getmSongAuthor());
        mSongButton = (ImageButton)v.findViewById(R.id.play_song_button);
        mSongButton.setImageResource(R.mipmap.play_button);
        mSongButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               if (status.toString().equals("play")) {
                                                   mPlayer = MediaPlayer.create(getContext(), eachSong.getmSongContent());
                                                   if (mPlayer!=null) {
                                                       mPlayer.seekTo(length);


                                                       mPlayer.start();
                                                       mBar.setMax(mPlayer.getDuration());

                                                   }
                                                   mSongButton.setImageResource(R.mipmap.pause_button);
                                                   status = "pause";

                                               } else {

                                                   mSongButton.setImageResource(R.mipmap.play_button);
                                                   length = mPlayer.getCurrentPosition();
                                                   mPlayer.stop();
                                                   status = "play";

                                               }


                                               final Handler mHandler = new Handler();
                                               final Runnable mRunnable = new Runnable() {
                                                   @Override
                                                   public void run() {
                                                       if (mPlayer.isPlaying()) {
                                                           int currentPos = mPlayer.getCurrentPosition();
                                                           mBar.setProgress(currentPos);

                                                           // set time remaining in song
                                                           int timeRemaining = mPlayer.getDuration() - mPlayer.getCurrentPosition();
                                                           int minutes = timeRemaining/ (60 * 1000);
                                                           int seconds = (timeRemaining / 1000) % 60;
                                                           String formatedTime = String.format("%d:%02d", minutes, seconds);
                                                           mTimeView.setText(formatedTime);

                                                           mHandler.postDelayed(this, 1000);

                                                       }

                                                   }
                                               };

                                               mHandler.removeCallbacks(mRunnable);
                                               mHandler.postDelayed(mRunnable, 1000);




                                           }

                                       } );

// issues
// text, text not moving



            mBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                      mPlayer.seekTo(i);
                      mBar.setProgress(i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


















        // set seekbar







        return v;
    }


}
