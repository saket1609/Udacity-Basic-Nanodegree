package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SAKET KUMAR SINGH on 09-08-2017.
 */

public class PlaylistClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_activity);

        Button button = (Button) findViewById(R.id.to_song);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button = new Intent(PlaylistClass.this, SongClass.class);
                startActivity(button);
            }
        });
        Button toAlbum = (Button) findViewById(R.id.to_album);
        toAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAlbum = new Intent(PlaylistClass.this, AlbumClass.class);
                startActivity(toAlbum);
            }
        });
    }
}