package io.picchi.tokei;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final Handler handler = new Handler();
        Timer timer = new Timer(false);
        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {
                               handler.post(new Runnable() {
                                   @Override
                                   public void run() {
                                       //メインへ
                                       Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
                                       startActivity(intent);
                                       finish();
                                   }
                               });
                           }
                       },
                1800);
    }
}



