package io.github.deltajulio.androidjokelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    public final static String JOKE_MESSAGE = "io.github.deltajulio.androidjokelib.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String jokeMessage = intent.getStringExtra(JOKE_MESSAGE);

        TextView jokeText = (TextView) findViewById(R.id.joke_text);
        jokeText.setText(jokeMessage);
    }
}
