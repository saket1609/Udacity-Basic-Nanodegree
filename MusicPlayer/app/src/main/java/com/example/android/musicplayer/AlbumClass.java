package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SAKET KUMAR SINGH on 09-08-2017.
 */

public class AlbumClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity);

        Button button = (Button)findViewById(R.id.to_playlist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button = new Intent(AlbumClass.this,PlaylistClass.class);
                startActivity(button);
            }
        });

        Button toStore = (Button) findViewById(R.id.to_store);
        toStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStore = new Intent(AlbumClass.this,PaymentActivity.class);
                startActivity(toStore);
            }
        });

    }
}