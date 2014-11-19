package com.techstorm.vietanh.timer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {

    Button btnStart, btnStop;
    TextView timer, txtQuestion, txtPoint;
    Question question;
    QuestionObject questionObject;
    int currentLevel = 0, point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        timer = (TextView) findViewById(R.id.timer);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtPoint = (TextView) findViewById(R.id.txtPoint);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Counter counter = new Counter(3000, 100);

        question = new Question();
        questionObject = question.getQuestion(currentLevel);

        txtQuestion.setText(questionObject.getQuestion());

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
                questionObject = question.getQuestion(currentLevel);
                txtQuestion.setText(questionObject.getQuestion());
//                if(questionObject.isResult()) {
//                    point++;
//                    txtPoint.setText(point);
//                } else {
//                    if (point > 0) {
//                        point--;
//                        txtPoint.setText(point);
//                    }
//                }
//                counter.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
                questionObject = question.getQuestion(currentLevel);
                txtQuestion.setText(questionObject.getQuestion());
//                if(!questionObject.isResult()) {
//                    point++;
//                    txtPoint.setText(point);
//                } else {
//                    if (point > 0) {
//                        point--;
//                        txtPoint.setText(point);
//                    }
//                }
//                counter.cancel();
            }
        });
    }

    public class Counter extends CountDownTimer {
        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millis) {
            long seconds = (long) Math.floor(millis / 1000);
            long mils = millis - (seconds * 1000);

            String time = String.format("%02d:%02d", seconds, mils / 10);
            timer.setText(time);
        }

        @Override
        public void onFinish() {
            Context context = getApplicationContext();
            CharSequence text = "Finished";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            this.start();
        }
    }
}
