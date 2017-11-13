package com.example.emma.seekbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {


private ListView mListView;
    private ArrayAdapter<Song> mArrayAdapter;
    private SeekBar mSeekbar;
    private ImageButton mButton;
    private TextView mTimeTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mListView = (ListView)findViewById(R.id.my_list_view);
        SongList mList = new SongList(getApplicationContext());
        List<Song> mSongs = mList.getmSongList();
        for ( Song song:
           mSongs  ) {

            Log.i("TAG", song.getmSongTitle());

        }
        mSeekbar = (SeekBar)findViewById(R.id.seekBar2);
        mTimeTextView = (TextView)findViewById(R.id.song_time_view);



        mArrayAdapter = new ListAdapter(getApplicationContext(), R.layout.custom_layout, mSongs, mSeekbar, mTimeTextView);
        // wire up the listview to the adapter

        mListView.setAdapter(mArrayAdapter);












    }
}
