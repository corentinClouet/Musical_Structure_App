package com.example.android.abnd_musicalstructure;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    // Create a list of songs
    ArrayList<Song> songs = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        //get parameters from MainActivity
        Bundle b = getIntent().getExtras();
        String type = b.getString("type");

        //set the list of songs
        if (type.equals("rockAndRoll")){
            setTitle("Rock'n Roll");
            songs.add(new Song("Chuck Berry", "Johnny B.Goode"));
            songs.add(new Song("Elvis Presley", "That's all right"));
            songs.add(new Song("Bill Haley", "Rock around the clock"));
            songs.add(new Song("Bo Diddley", "Who do you love"));
            songs.add(new Song("Eddie Cochran", "C'mon everybody"));
            songs.add(new Song("Buddy Holly", "Peggy Sue"));
            songs.add(new Song("Jerry Lee Lewis", "Great balls of fire"));
            songs.add(new Song("Little Richard", "Tutti Frutti"));
            songs.add(new Song("Gene Vincent", "Be-bop-a-lula"));
        }else if (type.equals("reggae")){
            setTitle("Reggae");
            songs.add(new Song("Bob Marley", "No Woman, No Cry"));
            songs.add(new Song("Max Romeo & The Upsetters", "I Chase The Devil"));
            songs.add(new Song("Barrington Levy", "Here I Come"));
            songs.add(new Song("Gregory Isaacs", "Universal Tribulation"));
            songs.add(new Song("Jacob Miller", "Tenement Yard"));
            songs.add(new Song("The Abyssinians", "Forward Onto Zion"));
            songs.add(new Song("The Heptones", "Country Boy"));
            songs.add(new Song("Toots & The Maytals", "Take Me Home Country Roads"));
            songs.add(new Song("U Roy", "Natty Rebel"));
        }else if (type.equals("electro")){
            setTitle("Electro");
            songs.add(new Song("JABBERWOCKY", "Photomaton"));
            songs.add(new Song("deadmau5", "Strobe "));
            songs.add(new Song("Avicii", "Levels "));
            songs.add(new Song("Daft Punk", "Harder, Better, Faster, Stronger"));
            songs.add(new Song("Zedd", "Spectrum "));
            songs.add(new Song("Martin Garrix", "Animals "));
            songs.add(new Song("Daft Punk", "Around the World"));
            songs.add(new Song("Avicii", "Fade Into Darkness "));
            songs.add(new Song("Skrillex", "Scary Monsters and Nice Sprites"));
        }

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called playlist_gridview
        GridView grid = (GridView) findViewById(R.id.playlist_gridview);

        // Make the {@link GridView} use the {@link SongAdapter} we created above, so that the
        // {@link GridView} will display list items for each {@link Song} in the list.
        grid.setAdapter(adapter);

        //start PlayerActivity with two parameters : the array and the selected position
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent playerIntent = new Intent(PlaylistActivity.this, PlayerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("arrayList", songs);
                bundle.putInt("position", position);
                playerIntent.putExtras(bundle);
                startActivity(playerIntent);
            }
        });
    }
}
