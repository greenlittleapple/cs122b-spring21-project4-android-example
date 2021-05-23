package edu.uci.ics.fabflixmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SingleMovie extends AppCompatActivity {

    String movieID;
    private TextView movieTitle;

    /*
      In Android, localhost is the address of the device or the emulator.
      To connect to your machine, you need to use the below IP address
     */
    private final String host = "10.0.2.2";
    private final String port = "8443";
    private final String domain = "cs122b-spring21-project2-login-cart-example";
    private final String baseURL = "https://" + host + ":" + port + "/" + domain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // upon creation, inflate and initialize the layout
        setContentView(R.layout.single_movie);
        movieTitle = findViewById(R.id.movieTitle);
        Intent intent = getIntent();
        movieID = intent.getStringExtra("id");

        movieTitle.setText(movieID);
    }
}