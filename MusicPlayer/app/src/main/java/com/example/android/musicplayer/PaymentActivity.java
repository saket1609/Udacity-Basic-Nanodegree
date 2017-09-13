package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SAKET KUMAR SINGH on 09-08-2017.
 */

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);

        Button button = (Button) findViewById(R.id.to_album);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button = new Intent(PaymentActivity.this, AlbumClass.class);
                startActivity(button);
            }
        });
        Button toHome = (Button) findViewById(R.id.to_home);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toHome = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(toHome);
            }
        });
    }
}