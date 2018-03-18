package com.example.android.abnd_musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Corentin on 10/03/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_item.xml layout with the ID name_textview
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_textview);
        // Get the name from the current Song object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getName());

        // Find the TextView in the song_item.xml layout with the ID artist_textview
        TextView artistTextview = (TextView) listItemView.findViewById(R.id.artist_textview);
        // Get the artist from the current Song object and
        // set this text on the artist TextView
        artistTextview.setText(currentSong.getArtist());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the GridView
        return listItemView;
    }
}
