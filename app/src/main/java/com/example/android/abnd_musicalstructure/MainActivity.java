package com.example.android.abnd_musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        LinearLayout rockAndRollPlaylist = (LinearLayout) findViewById(R.id.rockAndRollPlaylist);
        LinearLayout reggaePlaylist = (LinearLayout) findViewById(R.id.reggaePlaylist);
        LinearLayout electroPlaylist = (LinearLayout) findViewById(R.id.electroPlaylist);

        //start PlayListActivity with type of music
        rockAndRollPlaylist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                playlistIntent.putExtra("type", "rockAndRoll");
                startActivity(playlistIntent);
            }
        });

        reggaePlaylist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                playlistIntent.putExtra("type", "reggae");
                startActivity(playlistIntent);
            }
        });

        electroPlaylist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                playlistIntent.putExtra("type", "electro");
                startActivity(playlistIntent);
            }
        });
    }
}
