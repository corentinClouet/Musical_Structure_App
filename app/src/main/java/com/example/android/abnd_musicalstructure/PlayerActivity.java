package com.example.android.abnd_musicalstructure;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    int pos = 0;
    ArrayList<Song> songs = new ArrayList<>();
    TextView songTextView;
    TextView artistTextView;
    ImageView playButton;
    ImageView afterButton;
    ImageView beforeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //modify title in action bar
        setTitle("Audio Player");

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        //get views
        songTextView = findViewById(R.id.song_name_textview);
        artistTextView = findViewById(R.id.artist_textview);
        playButton = findViewById(R.id.play_button);
        afterButton = findViewById(R.id.after_button);
        beforeButton = findViewById(R.id.before_button);

        //get parameters from MainActivity
        Bundle b = getIntent().getExtras();
        pos = b.getInt("position");
        songs = b.getParcelableArrayList("arrayList");

        playButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                changeLectureState();
            }
        });

        afterButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                changeSong(1);
            }
        });

        beforeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                changeSong(-1);
            }
        });

        //init audio player with the current song
        initTitleAndArtist();
    }

    //return to the parent activity
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    //Show song name and artist name on the layout
    private void initTitleAndArtist(){
        songTextView.setText(songs.get(pos).getName());
        artistTextView.setText(songs.get(pos).getArtist());
    }

    //change the image resource to show the state of the lecture (play or pause)
    private void changeLectureState(){
        if (playButton.getTag().toString().equals("play_button")) {
            playButton.setImageResource(R.drawable.pause);
            playButton.setTag("pause_button");
        }else{
            playButton.setImageResource(R.drawable.play);
            playButton.setTag("play_button");
        }
    }

    //Play the next or previous song and go back to the start/end when the position is not correct
    private void changeSong(int i){
        if ((pos + i) < 0){
            pos = songs.size() - 1;
        }else if ((pos + i) > (songs.size() -1)){
            pos = 0;
        }else{
            pos += i;
        }
        initTitleAndArtist();
    }
}
