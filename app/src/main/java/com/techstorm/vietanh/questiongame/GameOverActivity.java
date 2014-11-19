/*
 * Copyright (c) 2014. <a href="http://facebook.com/vietanh.sgu">Viet Anh</a>.
 */

package com.techstorm.vietanh.questiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameOverActivity extends Activity {

    TextView txtScore;
    Button btnPlay;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        txtScore = (TextView) findViewById(R.id.txtScore);
        btnPlay = (Button) findViewById(R.id.btnPlay);

        Intent calledIntent = getIntent();
        Bundle bundle = calledIntent.getBundleExtra("package");
        score = bundle.getInt("point");

        txtScore.setText("Your score: " + String.valueOf(score));

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
