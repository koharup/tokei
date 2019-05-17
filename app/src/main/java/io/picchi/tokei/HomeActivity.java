package io.picchi.tokei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {


    public void info(View v){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }


    public void ClockActivity(View v){
        Intent intent = new Intent(this, ClockActivity.class);
        startActivity(intent);
    }


    public void ListActivity(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
