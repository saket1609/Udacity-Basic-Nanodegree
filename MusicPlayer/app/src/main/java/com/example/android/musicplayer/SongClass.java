package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SAKET KUMAR SINGH on 09-08-2017.
 */

public class SongClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_activity);

        Button button = (Button) findViewById(R.id.to_home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button = new Intent(SongClass.this, MainActivity.class);
                startActivity(button);
            }
        });

        Button buttonPlaylist = (Button) findViewById(R.id.to_playlist);
        buttonPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttontoplaylist = new Intent(SongClass.this, PlaylistClass.class);
                startActivity(buttontoplaylist);
            }
        });
    }
}
