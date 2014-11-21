package com.techstorm.vietanh.questiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Database.DatabaseHelper;


public class MainActivity extends Activity {

    QuestionGenerator questionGenerator;
    QuestionObject object;
    TextView txtQuestion, txtPoint, txtTimer, txtLevel;
    CountDownTimer clock;
    Button btnYes, btnNo;
    int level = 1;
    int point = 0;
    int seconds = 4;
    boolean isGameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPoint = (TextView) findViewById(R.id.txtPoint);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtTimer = (TextView) findViewById(R.id.txtTimer);
        txtLevel = (TextView) findViewById(R.id.txtLevel);
        btnYes = (Button) findViewById(R.id.btnYes);
        btnNo = (Button) findViewById(R.id.btnNo);

        questionGenerator = new QuestionGenerator();
        object = questionGenerator.getQuestion(4);

        txtQuestion.setText(object.getQuestion());
        txtPoint.setText("Điểm: 0");
        txtLevel.setText("Level: " + String.valueOf(level));

        DatabaseHelper databaseHelper;

        GenerateTimer(false);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (object.isResult()) {
                    Correct();
                } else {
                    if (!isGameOver) {
                        isGameOver = true;
                        GameOver();
                    }
                }
                object = questionGenerator.getQuestion(level);

                txtQuestion.setText(object.getQuestion());
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!object.isResult()) {
                    Correct();
                } else {
                    if (!isGameOver) {
                        isGameOver = true;
                        GameOver();
                    }
                }
                object = questionGenerator.getQuestion(level);

                txtQuestion.setText(object.getQuestion());
            }
        });
    }

    public void Correct() {
        point++;
        txtPoint.setText("Điểm: " + String.valueOf(point));
        level++;
        txtLevel.setText("Level: " + String.valueOf(level - 1));
        GenerateTimer(true);
    }

    public void GameOver() {
        if (isGameOver) {
            Intent intent = new Intent(this, GameOverActivity.class);

            Bundle bundle = new Bundle();
            bundle.putInt("point", point);
            intent.putExtra("package", bundle);

            startActivity(intent);
        }
    }

    public void GenerateTimer(boolean isRunning) {
        if (isRunning) {
            clock.cancel();
        }
        clock = new CountDownTimer(2000, 100) {
            @Override
            public void onTick(long l) {
                long seconds = l / 1000;
                txtTimer.setText("00:0" + String.valueOf(seconds + 1));
            }

            @Override
            public void onFinish() {
                if (!isGameOver) {
                    isGameOver = true;
                    GameOver();
                }
            }
        };
        clock.start();
    }
}
