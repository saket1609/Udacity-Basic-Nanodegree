package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSong = (Button) findViewById(R.id.song_button);
        ImageView imageViewSong = (ImageView) findViewById(R.id.song_image_view);
        buttonSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songIntent = new Intent(MainActivity.this, SongClass.class);
                startActivity(songIntent);
            }
        });
        imageViewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songimageIntent = new Intent(MainActivity.this, SongClass.class);
                startActivity(songimageIntent);
            }
        });

        Button buttonPlaylist = (Button) findViewById(R.id.playlist_button);
        buttonPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistClass.class);
                startActivity(playlistIntent);
            }
        });
        ImageView playlistImageView = (ImageView) findViewById(R.id.playlist_image_view);
        playlistImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistImageViewIntent = new Intent(MainActivity.this, PlaylistClass.class);
                startActivity(playlistImageViewIntent);
            }
        });
        Button buttonAlbum = (Button) findViewById(R.id.album_button);
        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AlbumIntent = new Intent(MainActivity.this, AlbumClass.class);
                startActivity(AlbumIntent);
            }
        });
        ImageView albumImageView = (ImageView) findViewById(R.id.album_image_view);
        albumImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumImageViewIntent = new Intent(MainActivity.this, AlbumClass.class);
                startActivity(albumImageViewIntent);
            }
        });
        Button buttonStore = (Button) findViewById(R.id.store_button);
        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeIntent = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(storeIntent);
            }
        });
        ImageView storeImageView = (ImageView) findViewById(R.id.store_image_view);
        storeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeImageViewIntent = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(storeImageViewIntent);
            }
        });
    }


}
