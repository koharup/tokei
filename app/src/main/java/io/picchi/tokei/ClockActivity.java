package io.picchi.tokei;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class ClockActivity extends AppCompatActivity {

    public void TodoActivity (View v){
        Intent intent = new Intent(this, TodoActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final Calendar alarmCalendar = Calendar.getInstance();

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClockActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        alarmCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        alarmCalendar.set(Calendar.MINUTE, minute);
                        alarmCalendar.set(Calendar.SECOND, 0);
                        timerSet(alarmCalendar);
                    }
                }, 8, 0, true);
                timePickerDialog.show();
            }
        });
    }



    public void timerSet(Calendar calendar){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(),AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), null), pendingIntent);


        Log.d("DEBUGGG", "Alarm SET!!");
    }




}
